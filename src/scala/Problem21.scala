package scala

import utils.Euler
import scala.collection.JavaConversions._

object Problem21 extends App {
  val d = (n:Int) => Euler.divisorList(n).toList.map(_.toInt).sum-n
  print((1 until 10000).filter(n => d(d(n)) == n && d(n) != n).sum)
}
