import scala.io.StdIn.readLine

object TripletSumToZero {
  //method calculates triplets sum equals to zero
  private def findTriplets(array: Array[Int], Size: Int) {
    var found: Boolean = false
    for(firstElement <- 0 until Size) {
      var setElement: Set[Int] = Set()
      for( secondElement <- firstElement + 1 until Size) {
        val sumElement = -(array(firstElement) + array(secondElement))
        if (setElement.contains(sumElement)) {
          println("The Values are: "+sumElement+", "+array(firstElement)+", "+array(secondElement))
          found = true
        }
        else {
          setElement += array(secondElement)
        }
      }
    }
    if (!found) {
      println(" No Triplet Found")
    }
  }
  // main method
  def main(args: Array[String]): Unit = {
    try {
    val Size = readLine("Enter the Size of the array:").toInt
    val MyArray = new Array[Int](Size)
    for (input <- 0 until Size) {
      MyArray(input) = readLine("Enter elements for the Array: ").toInt
    }
    findTriplets(MyArray,MyArray.length)
  }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter Only Numbers")
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
}
