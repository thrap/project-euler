package scala

import utils.Euler
import scala.jdk.CollectionConverters.CollectionHasAsScala

object Problem51 extends App {
  var pow = 6
  var primes = Euler.primeListBetween(Math.pow(10, pow-1).toInt, Math.pow(10, pow).toInt).asScala.map(_.toInt).toList

  var asd = List[(String, List[Int])]()
  for (r <- (1 until Math.pow(2, pow).toInt).map(Euler.toBinaryString(_, pow))) {
    asd ++= primes.filter(
      _.toString.zip(r).filter(_._2 == '1').map(_._1).mkString.toSet.size == 1)
      .groupBy(_.toString.zip(r).map(x => if (x._2 == '0') x._1 else "*").mkString
    ).toList
  }
  println(asd.maxBy(_._2.length)._2.min)
}
