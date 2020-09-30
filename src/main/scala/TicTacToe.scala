import scala.io.StdIn.readLine
import scala.sys.exit
import scala.util.Random
import scala.util.control.Breaks._

object TicTacToe {
  val Cell = 9
  var count = 0
  var switchPlayer = 2
  var position = 1
  var playerSymbol = "O"
  var computerSymbol = "X"
  var switchTurn = ""
  var winner = 2
  var block = 0
  var center = 0
  var middle = 0
  var board = new Array[String](10)

  //  method to reset the board
  def resettingBoard(): Unit = {
    for (counter <- 1 to 9) {
      board(counter) = "-"
    }
  }

  // method to display  board
  def displayBoard(): Unit = {
    println("-----TicTacToe Board-----" + "\n" +
      "| " + board(1) + " || " + board(2) + " || " + board(3) + " |" + "\n" +
      "| " + board(4) + " || " + board(5) + " || " + board(6) + " |" + "\n" +
      "| " + board(7) + " || " + board(8) + " || " + board(9) + " |" + "\n" +
      "-------------------------------")
  }

  // method to tossTheCoin
  def tossForTurn(): Unit = {
    println("Tossing a Coin..!!")
    if (Random.nextInt(2) == 0) {
      switchPlayer = 0
      println("Player won the toss.")
      var letter = readLine("Choose your letter X or O: ")
      if (letter == "X" || letter == "O") {
        if (letter == computerSymbol) {
          playerSymbol = letter
          computerSymbol = "O"
        }
        else {
          playerSymbol = letter
          computerSymbol = "X"
        }
      }
      else {
        letter = readLine("Please choose between X or O only: ")
      }
    }
    else {
      println("Computer won the toss\nComputer will play first.")
      switchPlayer = 1
    }
  }

  // method for Player playing game
  def playerIsPlaying(): Unit = {
    println("------------------->\nPlayer turn: ")
    displayBoard()
    println("Player Letter: " + playerSymbol + "\n" + "Computer Letter: " + computerSymbol)
    try {
      position = readLine("Enter Position: ").toInt
    } catch {
      case numberFormatException: NumberFormatException => position = readLine("Please Enter Int value only.....\n" +
        "Enter Position: ").toInt
    }
    switchTurn = playerSymbol
    checkingEmptyCell()
    board(position) = playerSymbol
    switchPlayer = 1
  }

  // computer turn and plays game like player
  def computerIsPlaying(): Unit = {
    println("---------------------->\nComputer Turn:")
    computerPlayingToWin()
    computerPlayingToBlock()
    if (block == 0) {
      takeAvailableCorners()
    }
    switchPlayer = 0
    displayBoard()
  }

  // method which validates positions
  def checkingEmptyCell(): Unit = {
    if (position > 0 && position < 10) {
      if (board(position) == "-") {
        println("............." + switchTurn + " is placed at " + position + "...............")
        count += 1
      }
      else {
        println("Cell is already occupied...!!!")
        switchPlayers()
      }
    }
    else {
      println("Invalid cell Value...!!!")
      switchPlayers()
    }
  }

  // method to switch between Player and Computer Move
  def switchPlayers(): Unit = {
    if (switchPlayer == 0) {
      playerIsPlaying()
    }
    else if (switchPlayer == 1) {
      computerIsPlaying()
    }
    winningCondition(switchTurn)
  }

  // method computer playing to win
  def computerPlayingToWin(): Unit = {
    for (counter <- 1 to Cell) {
      if (board(counter) == "-") {
        board(counter) = computerSymbol
        winningCondition(computerSymbol)
        if (winner == 1) {
          displayBoard()
          println("Winner is Computer")
          exit(0)
        }
        else {
          board(counter) = "-"
          block = 0
        }
      }
    }
  }

  // method computer will play to block the player from winning
  def computerPlayingToBlock(): Unit = {
    breakable {
      for (counter <- 1 to Cell) {
        if (board(counter) == "-") {
          board(counter) = playerSymbol
          winningCondition(playerSymbol)
          if (winner == 1) {
            board(counter) = computerSymbol
            winner = 0
            block = 1
            count += 1
            break
          }
          else {
            board(counter) = "-"
          }
        }
      }
    }
  }

  // method which checks empty corners to take place
  def takeAvailableCorners(): Unit = {
    val myPosList = List(1, 3, 7, 9)
    breakable {
      for (counter <- myPosList) {
        if (board(counter) == "-") {
          board(counter) = computerSymbol
          center = 1
          count += 1
          break
        }
      }
      takeCenter()
    }
  }

   // method which takes center
  def takeCenter(): Unit = {
    if (center != 1) {
      middle = (Cell + 1) / 2
      if (board(middle) == "-") {
        board(middle) = computerSymbol
        count += 1
      }
      else
        takeAvailableSides()
    }
  }

 // method which takes available cells
  def takeAvailableSides(): Unit = {

    for (counter <- 2 to 8 by 2) {
      breakable {
        if (board(counter) == "-") {
          board(counter) = computerSymbol
          count += 1
          break
        }
      }
    }
  }

  // method which checks game status
  def checkingGameStatus(): Unit = {
    if (winner == 1) {
      displayBoard()
      if (switchTurn == playerSymbol) {
        println("Winner is Player ")
      }
      else {
        println("Winner is Computer.")
      }

      exit
    }
    else if (count >= Cell) {
      println("=============================")
      displayBoard()
      println("TIE...!!")
    }
  }

  // method which checks winning condition wrt players
  def winningCondition(letter: String): Unit = {
    for (counter <- 1 to Cell by 3) {
      //To check winning condition for row
      if ((board(counter) == board(counter + 1)) && (board(counter + 1) == board(counter + 2)) && (board(counter + 2) == letter)) {
        winner = 1
      }
    }
    for (counter <- 1 to 3) {
      //To check winning condition for columns
      if ((board(counter) == board(counter + 3)) && (board(counter + 3) == board(counter + 6)) && (board(counter) == letter)) {
        winner = 1
      }
    }
    if ((board(1) == board(5)) && (board(5) == board(9)) && (board(5) == letter)) {
      winner = 1
    }
    if ((board(3) == board(5)) && (board(5) == board(7)) && (board(5) == letter)) {
      winner = 1
    }
  }

  // main method which calls methods
  def main(args: Array[String]): Unit = {
    resettingBoard()
    displayBoard()
    tossForTurn()
    while ( count != Cell) {
      switchPlayers()
      checkingGameStatus()
    }
  }
}

