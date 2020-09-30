import scala.io.StdIn.readLine

object GamblingSim {
  // function to generate win or loss and update results
  def gamblingFunction(): Unit = {
    try {
      var win, loss, counter = 0
      var stake = readLine("Enter the Stakes: ").toInt
      val Goal = readLine("Enter the Goal: ").toInt
      val Turns = readLine("Enter the number of Turns gambler will play: ").toInt
      val BaseValue = 100
      while (stake != Goal && stake != 0 && counter < Turns) {
        if (Math.random() > 0.5) {
          win += 1
          stake += 1
        }
        else {
          loss += 1
          stake -= 1
        }
        counter += 1
      }
      println("No of Turns Gambler Won :" + win + "\n" + "Win Percentage :" + (win.toFloat * BaseValue/ Turns.toFloat)
        + "\n" + "Loss Percentage :" + (loss.toFloat * BaseValue / Turns.toFloat))
    }
    catch{
      case numberFormatException: NumberFormatException =>
        println("Number exception please enter number only")
    }
  }
  // main method
  def main(args: Array[String]): Unit = {
    gamblingFunction()
  }
}
