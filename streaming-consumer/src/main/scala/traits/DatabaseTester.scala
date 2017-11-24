package traits

import java.sql.Connection

trait DatabaseTester {
  def countResultFromDb(connection: Connection){
    val countStatement = connection.createStatement
    val resultSet = countStatement.executeQuery("SELECT count(*) FROM imdb")
    resultSet.next()
    val count = resultSet.getInt("count(*)")
    println(count)
  }
}
