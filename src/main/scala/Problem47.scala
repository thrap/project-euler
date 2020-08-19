package scala

import utils.Euler
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Problem47 extends App {
  val N = 4
  def factors(n: Int) = Euler.primeFactorDistinctList(n).asScala.size
  def hasDistinctFactors(n: Int) = {
    !(0 until N).exists(i => factors(n+i) != N)
  }

  println(Stream.from(2).find(hasDistinctFactors))
}
