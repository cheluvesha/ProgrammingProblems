object HelloUser {
  // greets user based on input
  private def greetMessage(): Unit = {
    try {
      var flag = true
      while (flag) {
      println("Please Enter your Name: ")
      val UserName = scala.io.StdIn.readLine()
      if (UserName.length >= 3) {
        println("Hello " + UserName + ", How are you?")
        flag = false
      }
      else {
        println("Please Enter name with minimum three characters")
      }
    }
  }
    catch {
      case exception: Exception =>
        println(exception.printStackTrace())
    }
  }
  // main methods
  def main(args: Array[String]): Unit = {
    greetMessage()
  }
}

