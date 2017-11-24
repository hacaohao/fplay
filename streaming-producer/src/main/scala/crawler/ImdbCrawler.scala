package crawler

import scala.collection.mutable.ListBuffer
import org.apache.kafka.clients.producer._
import generator.Producer
import kantan.csv._
import kantan.csv.ops._
import org.apache.commons.lang3.StringEscapeUtils

class ImdbCrawler(producer: KafkaProducer[String, String]) extends Crawler {
  private val CSV_PATH = "/phim_raw_05102017.csv"
  private val SEPERATOR = "\t "
  private val XPATH = Map(
      "link"       -> "//table[contains(@class,'findList')]/tbody/tr/td[@class='result_text']/a",
      "director"   -> "//span[contains(@itemprop, 'director')]/a/span",
      "creator"    -> "//span[contains(@itemprop, 'creator')]/a/span",
      "stars"      -> "//span[contains(@itemprop, 'actors')]/a/span",
      "originTitle"-> "//div[@class='originalTitle']",
      "rate"       -> "//*[contains(@class,'ratingValue')]/strong/span[contains(@itemprop,'ratingValue')]",
      "country"    -> "//*[@id='titleDetails']/div/a[contains(@href, 'country_of_origin')]",
      "category"   -> "//span[contains(@itemprop, 'genre')]",
      "Year"	     -> "//*[@id='titleYear']/a[contains(@href, 'tt_ov_inf')]",
      "keys"       -> "//*[@id='titleStoryLine']/div/a/span[@itemprop='keywords']",
      "genres"     -> "//*[@id='titleStoryLine']/div[@itemprop='genre']/a"   
  )
  
  def crawl(){
    val originTitles = getOriginTitles(CSV_PATH)
    originTitles.foreach(titleCrawl => {
        println(titleCrawl)
        val urlCrawl = genUrl(titleCrawl)
        
        navigateTo(urlCrawl){
          val searchResultElement =  anchor having xPath(XPATH("link"))
          
          if (searchResultElement != null){
            forAll(searchResultElement){
              val title = from(anchor having xPath(".")).getTextContent
              val url = from(anchor having xPath(".")).getAttributes.getNamedItem("href").getTextContent
              val tempResult: Map[String, String] = Map(
                "titleCrawl" -> titleCrawl,
                "title"      -> title,
                "url"        -> s"http://www.imdb.com$url"
              )
              
              val crawlString = parse(tempResult)
              println(crawlString)
              producer.send(Producer.stringToRecord(crawlString))
            }
          }
        }
    })
  }
  
  private def parse(tempResult: Map[String, String]): String = {
    def getCategories():String = {
      val categoriesElement = span having xPath(XPATH("category"))
      var categoriesBuffer = new ListBuffer[String]
      
      forAll(categoriesElement){
        val category = from(span having xPath("."))
        
        if(category != null)
          categoriesBuffer += category.getTextContent
      }
      
      return categoriesBuffer.toList.mkString(", ").replace("\t+", " ")
    }
    
    def getActors(): String = {
      val actorsElement = span having xPath(XPATH("stars"))
      var actorsBuffer = new ListBuffer[String]
      
      forAll(actorsElement){
        val actor = from(span having xPath("."))
        
        if(actor != null)
          actorsBuffer += actor.getTextContent
      }
      
      return actorsBuffer.toList.mkString(", ").replace("\t+", " ")
    }
    
    def getDirectors(): String = {
      val directorsElement = span having xPath(XPATH("director"))
      var directorsBuffer = new ListBuffer[String]
      
      forAll(directorsElement){
        val director = from(span having xPath("."))
        
        if(director != null)
          directorsBuffer += director.getTextContent
      }
      
      return directorsBuffer.toList.mkString(", ").replace("\t+", " ")
    }
    
    def getCreators(): String = {
      val creatorsElement = span having xPath(XPATH("creator"))
      var creatorsBuffer = new ListBuffer[String]
      
      forAll(creatorsElement){
        val creator = from(span having xPath("."))
        
        if(creator != null)
          creatorsBuffer += creator.getTextContent
      }
      
      return creatorsBuffer.toList.mkString(", ").replace("\t+", " ")
    }
    
    def getKeys(): String = {
      val keysElement = span having xPath(XPATH("keys"))
      var keysBuffer = new ListBuffer[String]
      
      forAll(keysElement){
        val key = from(span having xPath(".")) 
        
        if(key != null)
          keysBuffer += key.getTextContent
      }
      
      return keysBuffer.toList.mkString(", ").replace("\t+", " ")
    }
    
    def getGenres(): String = {
      val genresElement = anchor having xPath(XPATH("genres"))
      var genresBuffer = new ListBuffer[String]
        
      forAll(genresElement){
        val genre = from(anchor having xPath("."))
        
        if(genre != null)
          genresBuffer += genre.getTextContent
      }
      
      return genresBuffer.toList.mkString(", ").replace("\t+", " ")
    }
    
    def getRate():String = {
      val rateElement = from(span having xPath(XPATH("rate")))
      
      if(rateElement != null){
        return rateElement.getTextContent.replace("\t+", " ")
      }
      
      return ""
    }
    
    def getCountry():String = {
      val countryElement = from(anchor having xPath(XPATH("country")))
      
      if(countryElement != null){
        return countryElement.getTextContent.replace("\t+", " ")
      }
      
      return ""
    }
    
    def getYear():String = {
      val yearElement = from(anchor having xPath(XPATH("Year")))
      
      if(yearElement != null){
        return yearElement.getTextContent.replace("\t+", " ")
      }
      
      return ""
    }
    
    def getOriginTitle():String = {
      val originTitleElement =  from(div having xPath(XPATH("originTitle")))
      
      if(originTitleElement != null){
        return originTitleElement.getTextContent.replace("\t+", " ")
      }
      
      return ""
    }
    
    val stringBuffer = new StringBuffer()
    navigateTo(tempResult("url")){
      stringBuffer.append(tempResult("url").replace("\t+", " ")).append(SEPERATOR)
                  .append(tempResult("title").replace("\t+", " ")).append(SEPERATOR)
                  .append(getCategories).append(SEPERATOR)
                  .append(getActors).append(SEPERATOR)
                  .append(getDirectors).append(SEPERATOR)
                  .append(getRate).append(SEPERATOR)
                  .append(getCreators).append(SEPERATOR)
                  .append(getOriginTitle).append(SEPERATOR)
                  .append(tempResult("titleCrawl").replace("\t+", " ")).append(SEPERATOR)
                  .append(getCountry).append(SEPERATOR)
                  .append(getYear).append(SEPERATOR)
                  .append(getKeys).append(SEPERATOR)
                  .append(getGenres)
    }
   
    return stringBuffer.toString
  }
  
  private def getOriginTitles(csvPath: String): List[String] = {
    val rawData = getClass.getResource(csvPath)
    val reader = rawData.asCsvReader[List[String]](rfc.withHeader)
    
    return reader.map(_.get).map(_.apply(1)).filter(_.nonEmpty).toList
  }
  
  private def genUrl(text: String): String ={
    val cleanedText = text.toString().trim().replace(" ", "+").replace(":", "%3A")
    return s"http://www.imdb.com/find?ref_=nv_sr_fn&q=$cleanedText&s=all"
  }  
}