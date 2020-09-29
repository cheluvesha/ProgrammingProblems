import java.io.FileNotFoundException

import scala.io.Source

object ReadFile {
  def main(args: Array[String]): Unit = {
    try {
    val FileName = "E:\\New folder\\Scala.txt"
    val Fsource = Source.fromFile(FileName)
    while (Fsource.hasNext) {
      print(Fsource.next())
    }
    //closing a file
    Fsource.close()
  }
    catch {
      case fileNotFoundException: FileNotFoundException =>
        println("File not Found Please Check the path")
    }
  }
}
