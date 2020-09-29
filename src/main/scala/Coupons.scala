import scala.util.Random

object Coupons {
  // generates Distinct Coupons
  def generateCoupons( total: Int): Unit ={
    var DistinctCouponNumbers: Set[Int] = Set()
    var totalCoupons = total
    while(totalCoupons != 0) {
      DistinctCouponNumbers += (1 + Random.nextInt(500) * Random.nextInt(100000))
      totalCoupons -= 1
    }
    DistinctCouponNumbers.foreach(coupon => println("Here is Your Coupon : "+coupon))
   }
  // main method reads input
  def main(args: Array[String]): Unit = {
    try {
      println("Please Enter how many coupons to generate: ")
      val TotalCoupons = scala.io.StdIn.readInt()
      generateCoupons(TotalCoupons)
    }
    catch {
      case numberFormatException: NumberFormatException =>
        println("Please Enter Proper Number")
    }
  }
}
