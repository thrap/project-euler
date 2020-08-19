package scala

import utils.Euler
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Problem124 extends App {
  def rad(n: Int): Int =
    if (n<2) 1 else Euler.primeFactorDistinctList(n).asScala.reduce(_*_)

  val E = (0 to 100000).map(n => (n, rad(n))).sortBy(_._2)

  println(E(10000))
}
