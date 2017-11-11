import java.util.Properties
import org.apache.kafka.clients.producer._
import crawler.ImdbCrawler
import generator.Producer

object StreamingProducer{
  def main(args: Array[String]){
    val producer = Producer.getStreamingProducer
    new ImdbCrawler(producer).crawl
    producer.close
  }
}
