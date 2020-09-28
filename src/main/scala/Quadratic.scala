import scala.io.StdIn.readLine

object Quadratic {
  // method which finds Quadratic Equation
  def quadraticEquation(): Unit = {
    try {
      val A = readLine("Enter A: ").toDouble
      val B = readLine("Enter B: ").toDouble
      val C = readLine("Enter C: ").toDouble
      val Delta = B * B - 4 * A * C
      if (Delta < 0)
        print(s"$Delta There are no real roots ")
      else {
        val Value1 = (-B + Math.sqrt(Delta)) / (2 * A)
        val Value2 = (-B - Math.sqrt(Delta)) / (2 * A)
        print("The roots are " + Value1 + " and " + Value2)
      }
    }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter Double Based Value")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
  // main method
  def main(args: Array[String]): Unit = {
    quadraticEquation()
  }
}