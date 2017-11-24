package generator

import org.apache.spark.streaming.dstream.InputDStream
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.streaming.kafka010.HasOffsetRanges
import org.apache.spark.streaming.kafka010.OffsetRange
import org.apache.spark.TaskContext

object Processor {
  def process(stream: InputDStream[ConsumerRecord[String, String]]){
    stream.foreachRDD(rdd => {
      val offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges

      rdd.foreachPartition(partition => {
        val offsetRange: OffsetRange = offsetRanges(TaskContext.get.partitionId)
        val connection = DatabaseConnector.getConnection

        partition.foreach(record => DatabaseConnector.saveToDb(connection, record.value, offsetRange))
        connection.close
      })
    })
  }
}
