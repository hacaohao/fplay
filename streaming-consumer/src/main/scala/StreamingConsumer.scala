import org.apache.spark.streaming._
import org.apache.spark.SparkConf
import org.apache.log4j.Logger
import org.apache.log4j.Level
import generator.Consumer
import generator.Processor

object StreamingConsumer {
  def main(args: Array[String]){
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)
    
    val conf = new SparkConf().setAppName("streaming-consumer").setMaster("local[*]")
    val streamingContext = new StreamingContext(conf, Seconds(1))
    val stream = Consumer.getStream(streamingContext)
    
    Processor.process(stream)
    
    streamingContext.start()       
    streamingContext.awaitTermination()
  }
}