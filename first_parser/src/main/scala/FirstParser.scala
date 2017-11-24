import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

//read text then convert to JSON
object FirstParser {
  def main(args: Array[String]) {
    val logFile = "hdfs://localhost:8020/home/hao/data/fplay-stats1.log" 
    val result = "hdfs://localhost:8020/home/hao/data/result1"
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    import spark.implicits._
    val logData = spark.read.textFile(logFile)
    val stringify = udf((vs: Seq[String]) => if(vs != null) s"""[${vs.mkString(",")}]""" else "")
    
    val processedData = logData.map(line => fixMistake(line))
    
    val df = spark.read.json(processedData)
   
    val queriedDf = df
              .select(FirstFieldConstants.REQUIRED_FIELDS.head, FirstFieldConstants.REQUIRED_FIELDS.tail:_*)
              .transform(ds => 
               TransformFields.REQUIRED_FIELDS.foldLeft(ds)((df, c) => df.withColumn(c, stringify(df.col(c))))
               )
    queriedDf.write.options(Map("delimiter" -> "\t", "header" -> "true")).csv(result)
        
    spark.stop()
  }
  
  def fixMistake(line: String): String = {
    line.replace("\\\"", "\"").replace("\"{", "{").replace("}\"", "}")
  }
}