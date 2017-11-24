package videopublish

import generator.Producer
import org.apache.kafka.clients.producer.KafkaProducer

import scala.io.Source

class FplayVideoInfoSender(producer: KafkaProducer[String, String]) {
  def sendVideoInfo(): Unit ={
    val filename = "/data/sample.js"
    for (line <- Source.fromFile(filename).getLines) {
      producer.send(Producer.stringToRecord(line))
    }
  }
}
