object HelloUser {
  def greetMessage(): Unit = {
    var flag = true
    while (flag) {
      println("Please Enter your Name: ")
      var userName = scala.io.StdIn.readLine()
      if (userName.length >= 3) {
        println("Hello " + userName + ", How are you?")
        flag = false
      }
      else {
        println("Please Enter name with minimum three characters")
      }
    }
  }
  def main(args: Array[String]): Unit = {
    greetMessage()
  }
}

