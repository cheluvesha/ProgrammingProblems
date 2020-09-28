import scala.io.StdIn.readLine
import scala.math.sqrt

object Distance {
  // method which calculates Distance
  def distance(): Unit = {
    try{
      val X = readLine("Enter x: ").toInt
      val Y = readLine("Enter y: ").toInt
      val Distance = sqrt(X*X + Y*Y)
      print("Euclidean Distance is : "+Distance)
    }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter Number based value")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
  // main method
  def main(args: Array[String]): Unit = {
    distance()
  }

}
