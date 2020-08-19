package scala

import scala.io.Source._

object Problem13 extends App {
  println(fromFile("src/input-files/p13.txt").getLines().map(BigInt(_)).sum.toString().substring(0,10))

}
