package scala

import utils.Euler
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Problem77 extends App {
  val p = Array.fill(1000){0}
  p(0) = 1
  val primes = Euler.primeList(1000).asScala.map(_.toInt)
  for (n <- primes; i <- n until p.length)
    p(i) += p(i-n)
  println(p.zipWithIndex.find(_._1 > 5000).get._2)
}
