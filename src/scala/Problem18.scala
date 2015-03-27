package scala

import scala.io.Source._

object Problem18 extends App {
  def biggest(board:Array[Array[Int]]):Int = {
    for (y <- (0 to board.length-2).reverse)
      for (x <- 0 until board(y).length)
        board(y)(x) += Math.max(board(y+1)(x), board(y+1)(x+1))
    board(0)(0)
  }

  print(biggest(fromFile("src/input-files/p18.txt").getLines().toArray.map(_.split(' ').map(_.toInt))))
}
