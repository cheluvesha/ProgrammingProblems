object PrimeFactors {
  // method which generates factors
  private def factorsGenerate(number: Int): Unit = {
    var value = number
    for (digit <- 2 to value) {
      while (value % digit == 0) {
        print(digit + " ")
        value /= digit
      }
    }
  }
  // main method
  def main(args: Array[String]): Unit = {
    try {
    println("Enter the Number to find prime factors: ")
    var number = scala.io.StdIn.readInt()
    factorsGenerate(number)
  }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter a Proper Number")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
}
