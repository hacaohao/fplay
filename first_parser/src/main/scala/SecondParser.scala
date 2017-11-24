import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SecondParser {
  def main(args: Array[String]) {
    val logFile = "hdfs://localhost:8020/home/hao/data/fplay-stats1.log"
    val result = "hdfs://localhost:8020/home/hao/data/result2"
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    import spark.implicits._
    val stringify = udf((vs: Seq[String]) => if(vs != null) s"""[${vs.mkString(",")}]""" else "")
    val df = spark.read.json(logFile)
      .withColumn(SecondFieldConstants.NEW_COLUMN_NAME,
        from_json(col("requests.arg_co"), ARG_COSchema.schema))

    val queriedDf = df
      .select(SecondFieldConstants.REQUIRED_FIELDS.head, SecondFieldConstants.REQUIRED_FIELDS.tail:_*)
      .transform(ds =>
        TransformFields.REQUIRED_FIELDS.foldLeft(ds)((df, c) => df.withColumn(c, stringify(df.col(c))))
      )

    queriedDf.write.options(Map("delimiter" -> "\t", "header" -> "true")).csv(result)

    spark.stop()
  }
}
