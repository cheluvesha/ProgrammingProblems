object PrimeFactors {
  def factorsGenerate(number: Int): Unit = {
    var value = number
    for (digit <- 2 to value) {
      while (value % digit == 0) {
        print(digit + " ")
        value /= digit
      }
    }
  }
  def main(args: Array[String]): Unit = {
    println("Enter the Number to find prime factors: ")
    var number = scala.io.StdIn.readInt()
    factorsGenerate(number)
  }
}
