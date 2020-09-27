object HarmonicNumber {
  val unit = 1
  def generateHarmonic(num : Float): Float = {
    if(num < 2) unit else (unit/num + (generateHarmonic(num - unit)))
  }
  def main(args : Array[String]): Unit ={
    println("Please Enter a number: ")
    val inputNum = scala.io.StdIn.readInt()
    val sum = generateHarmonic(inputNum)
    println(f"The total Harmonic sum is : $sum%.2f")
  }
}
