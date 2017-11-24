
import crawler.ImdbCrawler
import generator.Producer
import videopublish.FplayVideoInfoSender

object StreamingProducer{
  def main(args: Array[String]){
    val producer = Producer.getStreamingProducer
    //new ImdbCrawler(producer).crawl
    new FplayVideoInfoSender(producer).sendVideoInfo
    producer.close
  }
}
