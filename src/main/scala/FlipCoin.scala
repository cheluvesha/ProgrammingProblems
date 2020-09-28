import java.lang.NumberFormatException

import scala.util.Random

object FlipCoin {
  // to calculate percentage
  val Value = 100
  // random number generate and calculating the percentage
  private def coinPercentage(): Unit = {
    var headCount = 0
    var tailCount = 0
    println("Please Enter the Number of times to FlipCoin : ")
    try {
      var tossNumber = scala.io.StdIn.readInt()
      while (tossNumber > 0) {
        val Result = Random.nextInt(2)
        if (Result == 1) {
          headCount += 1
        }
        else {
          tailCount += 1
        }
        tossNumber -= 1
      }
      val HeadPercentage = (headCount.toFloat / (headCount + tailCount)) * Value
      val TailPercentage = Value - HeadPercentage
      println(f"Head Percentage : $HeadPercentage%.0f%% and Tail Percentage $TailPercentage%.0f%%")
    }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter a Proper Number")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
  // main method which calls coinPercentage method
  def main(args: Array[String]): Unit = {
    coinPercentage()
  }
}
