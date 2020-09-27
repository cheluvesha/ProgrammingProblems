object LeapYear {
  def checkLeapYearOrNot(year: Int): Boolean = {
    (((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)))
  }
  def main(args: Array[String]): Unit = {
    println("Please Enter a Four Digit based Year to check: ")
    val year = scala.io.StdIn.readInt()
    val conclusion = checkLeapYearOrNot(year)
    if (conclusion) {
      println(s"$year is a leap year")
    }
    else {
      println(s"$year is not a leap year")
    }
  }
}
