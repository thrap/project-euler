package scala

import scala.io.Source._

object Problem99 extends App {
  val tuples = fromFile("src/input-files/p99.txt").getLines().map(s => s.split(",").map(_.toLong))
  println(tuples.zipWithIndex.maxBy(x => x._1(1)*Math.log(x._1(0)))._2 + 1)
}
