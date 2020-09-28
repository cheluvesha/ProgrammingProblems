import scala.io.StdIn.readLine

object WindChill {
    // function calculates WindChill
    def calculateWindChill(): Unit ={
      try {
        val T = readLine("Enter value of T: ").toDouble
        val V = readLine("Enter value of V: ").toDouble
        val W = 35.74 + 0.6215 * T + (0.4275 * T - 35.75) * Math.pow(V, 0.16)
        println("Temperature: " + T)
        println("Wind Speed: " + V)
        println(f"Wind Chill: $W%.2f")
    }
      catch {
        case numberFormatException: NumberFormatException =>
          println("Enter Double Based Value")
        case exception: Exception =>
          println(exception.printStackTrace())
      }
    }
  // main method
  def main(args: Array[String]): Unit = {
    calculateWindChill()
    }
  }

