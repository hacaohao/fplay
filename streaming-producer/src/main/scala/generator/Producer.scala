package generator

import java.util.Properties
import org.apache.kafka.clients.producer._

object Producer {
  private[this] val TOPIC = "test"

  def getStreamingProducer(): KafkaProducer[String, String] = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("acks", "1")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    
    return new KafkaProducer[String, String](props)
  }
  
  def stringToRecord(value: String): ProducerRecord[String, String] = {
    val key = "key "+ System.currentTimeMillis.toString
    println(key)
    return new ProducerRecord(TOPIC, key, value)
  }
}