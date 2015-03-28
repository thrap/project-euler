package scala

import scala.io.Source._

object Problem96 extends App {

  def solved(board:Array[Array[Int]]): Array[Array[Int]] = {
    def square(x:Int, y:Int) = (0 until 9).map(i => board(3*(y/3)+i%3)(3*(x/3)+i/3)).toSet
    def row(x:Int, y:Int) = board(y).toSet
    def column(x:Int, y:Int) = (0 until 9).map(board(_)(x)).toSet
    def possible(x:Int, y:Int) = (1 to 9).toSet -- square(x,y).union(row(x,y)).union(column(x,y))

    def solve(i: Int): Option[Array[Array[Int]]] = {
      if (i == 9 * 9)
        return Some(board)
      val x = i % 9
      val y = i / 9
      if (board(y)(x) != 0) {
        solve(i + 1)
      } else {
        for (n <- possible(x, y)) {
          board(y)(x) = n
          val solution = solve(i + 1)
          if (solution.isDefined)
            return solution
          board(y)(x) = 0
        }
        None
      }
    }
    solve(0).get
  }

  var sum = 0
  val boards = fromFile("src/input-files/p96.txt").mkString.split( """Grid \d\d\n""").tail.map(_.split("\n").map(_.toArray.map(_.toInt - '0')))
  for (board <- boards) {
    for (row <- solved(board))
      println(row.mkString)
    println()
    sum += board(0).mkString.substring(0,3).toInt
  }
  println(sum)
}
