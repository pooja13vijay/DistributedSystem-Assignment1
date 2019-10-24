import java.io.{DataInputStream, DataOutputStream}
import java.net.Socket

object Client extends App {
  var client = new Socket( "127.0.0.1", 6000 )
  val is = new DataInputStream(client.getInputStream() )
  val os = new DataOutputStream( client.getOutputStream() )
  println("1. Apple, 2. Orange, 3.Grapes, 4.Peach, 5.watermelon")
  println("Enter the item name")
  os.writeBytes(s"${scala.io.StdIn.readLine("Enter item: ")}\n")
  var line: String = is.readLine();
  println(s"Price is RM $line")
  client.close()
}
