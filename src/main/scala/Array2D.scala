package com.Function

import scala.io.StdIn.readLine
object Array2D {
  // reads 2D array and Prints array
  def readArrayAndPrintArray(): Unit = {
    try {
      val Row = readLine("Enter a Row of matrix:").toInt
      val Column = readLine("Enter a columns of matrix:").toInt
      val MyArray = Array.ofDim[Int](Row, Column)
      for (rowValue <- 0 until Row) {
        for (colValue <- 0 until Column) {
          MyArray(rowValue)(colValue) = readLine("Enter value for Row:" + rowValue + " col:" + colValue + "  :").toInt
        }
      }
      for (rowValue <- 0 until Row) {
        for (colValue <- 0 until Column) {
          print(MyArray(rowValue)(colValue) + " ")
        }
        println()
      }
    }
    catch {
      case numberFormatException: NumberFormatException => println("Please enter number only")
      case negativeArraySizeException: NegativeArraySizeException => println("Please enter positive number only")
    }
  }
  // main method
  def main(args: Array[String]): Unit = {
    readArrayAndPrintArray()
  }
}