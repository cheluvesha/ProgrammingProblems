import java.util.concurrent.TimeUnit
import scala.io.StdIn.readLine

object StopWatch {

  // calculates time lapse between start and end
  def stopWatchCall(): Unit = {
    try {
      var start: Long = 0
      var end: Long = 0
      var press: String = readLine("Enter Any key to start stopwatch:")
      start = System.nanoTime()
      press = readLine("Enter Any key to stop stopwatch:")
      end = System.nanoTime()
      println("%d Secs".format(TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS)))
    }
    catch {
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }

  // main method
  def main(args: Array[String]): Unit = {
    stopWatchCall()
  }
}
