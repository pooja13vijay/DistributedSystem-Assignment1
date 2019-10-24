import java.sql.{Connection, DriverManager}

trait data{
  // connect to the database named "mysql" on port 3306 of localhost
  val url = "jdbc:mysql://localhost:3306/MySql"
  val driver = "com.mysql.cj.jdbc.Driver"
  val username = "root"
  val password = "root"
  var connection:Connection = _
  Class.forName(driver)
  connection = DriverManager.getConnection(url, username, password)
  val statement = connection.createStatement


}

object Database extends  data{
  def createTable(): Unit = {
    val makeTable : String =
      "CREATE TABLE items " +
        "(name VARCHAR(255) not NULL, " +
        " price decimal(4,2), " +
        " PRIMARY KEY ( name))"
    statement.executeUpdate(makeTable)
  }

  def insertIntoTable (): Unit ={
    val item1 = statement.executeUpdate("INSERT INTO items VALUES ('Apple', 3.25)")
    val item2 = statement.executeUpdate("INSERT INTO items VALUES ('Orange', 4.67)")
    val item3 = statement.executeUpdate("INSERT INTO items VALUES ('Grapes', 9.46)")
    val item4 = statement.executeUpdate("INSERT INTO items VALUES ('Peach', 8.23)")
    val item5 = statement.executeUpdate("INSERT INTO items VALUES ('watermelon', 1.34)")
  }



}
