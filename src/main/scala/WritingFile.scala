import java.io._
object WritingFile {
  def main(args: Array[String]): Unit = {
    try {
      val FileObject = new File("E:\\New folder\\Scala.txt")
      val printWriter = new PrintWriter(FileObject)
      printWriter.write("Hello, This is a scala file")
      printWriter.close()
  }
    catch {
      case fileNotFoundException: FileNotFoundException =>
        println("Please check the Path")
    }
  }
}
