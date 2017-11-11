import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.11",
      version      := "0.1.0"
    )),
    name := "streaming-producer",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.apache.kafka" % "kafka_2.11" % "0.10.2.1",
    libraryDependencies += "net.sourceforge.htmlunit" % "htmlunit" % "2.15",
    libraryDependencies += "org.specs2" % "specs2-core_2.11" % "3.6.2",
    libraryDependencies += "com.typesafe.akka" % "akka-http-experimental_2.11" % "1.0-M1",
    libraryDependencies += "com.typesafe.akka" % "akka-http-xml-experimental_2.11" % "1.0-M1",
    libraryDependencies += "com.nrinaudo" %% "kantan.csv-scalaz" % "0.3.0"
  )
