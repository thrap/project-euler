package scala

import utils.Euler
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Problem21 extends App {
  val d = (n:Int) => Euler.divisorList(n).asScala.map(_.toInt).sum-n
  print((1 until 10000).filter(n => d(d(n)) == n && d(n) != n).sum)
}
