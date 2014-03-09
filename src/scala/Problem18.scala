package scala

import scala.io.Source._

object Problem18 extends App {
  def shortest(board:Array[Array[Int]]):Int = {
    var max = 0
    def recurse(x:Int, y:Int, sum:Int):Unit = {
      if (y < 15) {
        recurse(x, y+1, sum+board(y)(x))
        recurse(x+1, y+1, sum+board(y)(x))
      } else {
        max = Math.max(max, sum)
      }
    }
    recurse(0,0,0)
    max
  }

  print(shortest(fromFile("src/input-files/p18.txt").getLines().toArray.map(_.split(' ').map(_.toInt))))

}
