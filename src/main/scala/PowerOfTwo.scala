object PowerOfTwo {
  val digit = 2
  def tableGenerate(max: Int): Unit = {
    for( table <- 1 to (max/digit)) {
      println("2 X "+table+" = "+(digit*table))
    }
  }
  def main(args: Array[String]): Unit = {
    print("Enter a number: ")
    val number = scala.io.StdIn.readInt()
    val maxLimit = scala.math.pow(digit,number).toInt
    tableGenerate(maxLimit)
  }
}

