import scala.util.Random

object FlipCoin {
  val VALUE = 100
  def coinPercentage(): Unit = {
    var headCount = 0
    var tailCount = 0
    println("Please Enter the Number of times to FlipCoin : ")
    var tossNumber = scala.io.StdIn.readInt()
    while (tossNumber > 0) {
      var result = Random.nextInt(2)
      if (result == 1) {
        headCount += 1
      }
      else {
        tailCount += 1
      }
      tossNumber -= 1
    }
    val headPercentage = (headCount.toFloat / (headCount+ tailCount)) * VALUE
    val tailPercentage = VALUE - headPercentage
    println(f"Head Percentage : $headPercentage%.0f%% and Tail Percentage $tailPercentage%.0f%%")
  }
  def main(args: Array[String]): Unit = {
    coinPercentage()
  }
}
