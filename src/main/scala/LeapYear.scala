object LeapYear {
  // condition which checks leap year
  private def checkLeapYearOrNot(year: Int): Boolean = {
    (((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)))
  }
  // main method
  def main(args: Array[String]): Unit = {
    try {
    println("Please Enter a Four Digit based Year to check: ")
    val Year = scala.io.StdIn.readInt()
    val Conclusion = checkLeapYearOrNot(Year)
    if (Conclusion) {
      println(s"$Year is a leap Year")
    }
    else {
      println(s"$Year is not a leap Year")
    }
  }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter a Proper Four Digit NUmber")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
}
