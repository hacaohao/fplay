import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.LongType
import org.apache.spark.sql.types.BooleanType
import org.apache.spark.sql.types.ArrayType
import scala.collection.Seq

object ARG_COSchema {
  val schema = StructType(Seq(
      StructField("schema", StringType, true),
      StructField("data", ArrayType(
          StructType(Seq(
              StructField("schema", StringType, true),
              StructField("data", StructType(Seq(
                    StructField("_ga", StringType, true), 
                    StructField("androidIdfa", StringType, true),
                    StructField("app_dur", LongType, true),
                    StructField("app_st", StringType, true),
                    StructField("app_ver", StringType, true),
                    StructField("appleIdfa", StringType, true),
                    StructField("appleIdfv", StringType, true),
                    StructField("auto_run", BooleanType, true),
                    StructField("box_Manufacturer", StringType, true),
                    StructField("carrier", StringType, true),
                    StructField("connectEnd", LongType, true),
                    StructField("connectStart", LongType, true),
                    StructField("deviceManufacturer", StringType, true),
                    StructField("deviceManufactuter", StringType, true),
                    StructField("deviceModel", StringType, true),
                    StructField("domComplete", LongType, true),
                    StructField("domContentLoadedEventEnd", LongType, true),
                    StructField("domContentLoadedEventStart", LongType, true),
                    StructField("domInteractive", LongType, true),
                    StructField("domLoading", LongType, true),
                    StructField("domainLookupEnd", LongType, true),
                    StructField("domainLookupStart", LongType, true),
                    StructField("fetchStart", LongType, true),
                    StructField("firmware_version", StringType, true),
                    StructField("firstEventId", StringType, true),
                    StructField("id", StringType, true),
                    StructField("link", StringType, true),
                    StructField("loadEventEnd", LongType, true),
                    StructField("loadEventStart", LongType, true),
                    StructField("navigationStart", LongType, true),
                    StructField("networkTechnology", StringType, true),
                    StructField("networkType", StringType, true),
                    StructField("openIdfa", StringType, true),
                    StructField("osType", StringType, true),
                    StructField("osVersion", StringType, true),
                    StructField("pl_n_buff", StringType, true),
                    StructField("pl_pause_dur", StringType, true),
                    StructField("pl_pct", StringType, true),
                    StructField("pl_player", StringType, true),
                    StructField("pl_rbuff", StringType, true),
                    StructField("pl_sbuff", StringType, true),
                    StructField("pl_sid", StringType, true),
                    StructField("pl_st", StringType, true),
                    StructField("pl_time", StringType, true),
                    StructField("pl_video_len", StringType, true),
                    StructField("platform", StringType, true),
                    StructField("previousSessionId", StringType, true),
                    StructField("redirectEnd", LongType, true),
                    StructField("redirectStart", LongType, true),
                    StructField("requestStart", LongType, true),
                    StructField("responseEnd", LongType, true),
                    StructField("responseStart", LongType, true),
                    StructField("scr_dur", LongType, true),
                    StructField("scr_id", StringType, true),
                    StructField("scr_idx", LongType, true),
                    StructField("scr_key", StringType, true),
                    StructField("scr_path", StringType, true),
                    StructField("scr_type", StringType, true),
                    StructField("secureConnectionStart", LongType, true),
                    StructField("sessionId", StringType, true),
                    StructField("sessionIndex", LongType, true),
                    StructField("src_idx", LongType, true),
                    StructField("storageMechanism", StringType, true),
                    StructField("t_app_ver", StringType, true),
                    StructField("unloadEventEnd", LongType, true),
                    StructField("unloadEventStart", LongType, true),
                    StructField("userId", StringType, true)
              )), true)
          ))
      ), true)
  ))
}