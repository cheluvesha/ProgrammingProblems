object PowerOfTwo {
  val digit = 2
  // method which generates table wrt to max limit
  def tableGenerate(max: Int): Unit = {
    for( table <- 1 to (max/digit)) {
      println("2 X "+table+" = "+(digit*table))
    }
  }
  // main method reads user input
  def main(args: Array[String]): Unit = {
    try {
      print("Enter a number: ")
      val number = scala.io.StdIn.readInt()
      val maxLimit = scala.math.pow(digit,number).toInt
      tableGenerate(maxLimit)
    }
    catch {
      case numberFormatException: NumberFormatException  =>
        println("Please Enter a Proper Number")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
}

