package scala

import utils.Euler
import scala.collection.JavaConversions._

object Problem47 extends App {
  val N = 4
  def factors(n: Int) = Euler.primeFactorDistinctList(n).toList.size
  def hasDistinctFactors(n: Int) = {
    !(0 until N).exists(i => factors(n+i) != N)
  }

  println(Stream.from(2).find(hasDistinctFactors))
}
