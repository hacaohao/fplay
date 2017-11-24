name := "streaming-consumer"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.2.0"
libraryDependencies += "org.apache.kafka" % "kafka_2.11" % "0.10.2.1"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-10_2.11" % "2.2.0"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.24"
libraryDependencies += "org.scalikejdbc" % "scalikejdbc_2.11" % "3.1.0"