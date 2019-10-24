import java.io.{DataInputStream, DataOutputStream}
import java.net.{ServerSocket, Socket}
import java.sql.ResultSet

import Server.server
import scala.concurrent.ExecutionContext.Implicits.global


import scala.concurrent.Future

object Server extends App with data {

  val server = new ServerSocket(6000)
  Database.createTable()
  Database.insertIntoTable()
  while(true){
    val client: Socket = server.accept()
    val f = Future({
      val is = new DataInputStream(client.getInputStream())
      val os = new DataOutputStream(client.getOutputStream())
      var line: String = is.readLine()
      //var ref =Firebase.ref(line)
      println(s"Check price for : $line")
      //get the row that satisfy the query
      val result : ResultSet = statement.executeQuery(s"SELECT price FROM items WHERE name LIKE '%$line%'")
      val results = Iterator.from(0).takeWhile(_ => result.next()).map(_ => result.getDouble("price")).toList
      os.writeBytes(s"${results(0)}\n")
      client.close()
    })

  }
}
