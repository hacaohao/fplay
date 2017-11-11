package generator

import java.sql.DriverManager
import java.sql.Connection
import org.apache.commons.lang.StringEscapeUtils
import org.apache.kafka.common.TopicPartition
import org.apache.spark.streaming.kafka010.OffsetRange
import traits._
import scalikejdbc.ConnectionPoolSettings
import scalikejdbc.ConnectionPool

object DatabaseConnector extends java.io.Serializable with QueryConstructor with DatabaseTester {
  private val DRIVER = "com.mysql.jdbc.Driver"
  private val URL = "jdbc:mysql://localhost/test"
  private val USERNAME = "root"
  private val PASSWORD = "123456"
  val settings = ConnectionPoolSettings(
      initialSize = 5,
      maxSize = 20,
      connectionTimeoutMillis = 3000L)
      
  Class.forName(DRIVER)  
  ConnectionPool.singleton(URL, USERNAME, PASSWORD, settings)
  
  def getConnection(): Connection = {
    return ConnectionPool.borrow()
  }
  
  def getKafkaPartitionOffsets(): Option[Map[TopicPartition, Long]] = {
    val connection = getConnection
    try{
      val retrieveStatement = connection.createStatement
      val resultSet = retrieveStatement.executeQuery("SELECT * from kafka_offset")
      
      if(!resultSet.next){
        return None
      }else{
        var fromOffsets: Map[TopicPartition, Long] = Map()
        
        do{
          val topic = resultSet.getString("topic")
          val partition = resultSet.getInt("partition_index")
          val offset = (resultSet.getLong("offset") + 1)
          println(offset)
          
          fromOffsets += (new TopicPartition(topic, partition) -> offset)
        }while(resultSet.next)
          
        return Some(fromOffsets)  
      }
    }catch {
      case e: Exception => println("Error when executing query: " + e.printStackTrace) 
      return None
    }finally{
      connection.close
    }
  }
  
  def saveToDb(connection: Connection, tsv: String, partitionInfo: OffsetRange) {
    try{
      connection.setAutoCommit(false)
      
      val insertStatement = connection.createStatement
      insertStatement.execute(constructQueryFrom(tsv))
      updatePartitionOffset(connection, partitionInfo)
      countResultFromDb(connection)
      
      connection.commit
    }catch {
      case e: Exception => println("Error when executing query: " + e.printStackTrace) 
      connection.rollback
    }finally{
      connection.setAutoCommit(true)
    }
  }
  
  private def updatePartitionOffset(connection: Connection, partitionInfo: OffsetRange){
      val topic = partitionInfo.topic
      val partition = partitionInfo.partition
      val offset = partitionInfo.fromOffset
      
      val retrieveStatement = connection.createStatement
      val resultSet = retrieveStatement.executeQuery("SELECT * from kafka_offset")
      
      if(!resultSet.next){
        val statement = connection.prepareStatement(s"INSERT INTO kafka_offset VALUES(null, ?, ?, ?)")
        statement.setString(1, topic)
        statement.setInt(2, partition)
        statement.setLong(3, offset)
        statement.execute()
      }else{
        val statement = connection.prepareStatement(s"UPDATE kafka_offset SET offset = ? WHERE topic = ? AND partition_index = ?")
        statement.setLong(1, offset)
        statement.setString(2, topic)
        statement.setInt(3, partition)
        statement.executeUpdate()
      }
  }
}