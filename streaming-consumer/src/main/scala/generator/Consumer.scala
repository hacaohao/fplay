package generator

import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Assign
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming._
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.kafka.common.serialization.StringDeserializer

object Consumer {
  private[this] val TOPICS = Array("test")

  private[this] val KAFKA_PARAMS = Map[String, Object](
    "bootstrap.servers" -> "localhost:9092",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "123456",
    "auto.offset.reset" -> "latest",
    "enable.auto.commit" -> (false: java.lang.Boolean)
  )

  def getStream(streamingContext: StreamingContext): InputDStream[ConsumerRecord[String, String]] = {
    val strategy = DatabaseConnector.getKafkaPartitionOffsets match{
      case Some(fromOffsets) => Assign[String, String](fromOffsets.keys.toList, KAFKA_PARAMS, fromOffsets)
      case None => Subscribe[String, String](TOPICS, KAFKA_PARAMS)
    }

    return KafkaUtils.createDirectStream[String, String](
      streamingContext,
      PreferConsistent,
      strategy
    )

  }
}
