package scala

import scala.io.Source._

object Problem107 extends App {
  val neighbours = fromFile("src/input-files/p107.txt").getLines().map(_.replace("-","10000").split(',').map(_.toInt).toList).toList

  def mst(included:List[Int]): Int = {
    if (included.length == neighbours.length)
      return 0
    val min = included.map(neighbours(_).zipWithIndex).flatten.filterNot(x => included.contains(x._2)).minBy(_._1)
    min._1 + mst(min._2 :: included)
  }
  println(neighbours.flatten.filter(_ < 10000).sum/2 - mst(List(0)))
}
