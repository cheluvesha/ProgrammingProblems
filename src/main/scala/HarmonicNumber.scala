object HarmonicNumber {
  val Unit = 1
  // method which generates Harmonic Sum
  private def generateHarmonic(num : Float): Float = {
    if(num < 2) Unit else (Unit/num + (generateHarmonic(num - Unit)))
  }
  // main method which reads input
  def main(args : Array[String]): Unit ={
    try {
    println("Please Enter a number: ")
    val InputYear = scala.io.StdIn.readInt()
    val Sum = generateHarmonic(InputYear)
    println(f"The total Harmonic Sum is : $Sum%.2f")
  }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter Proper Number")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
}
