package scala

import utils.Euler
import scala.collection.mutable
import scala.collection.JavaConversions._

object Problem500 extends App {
  case class Pow(p: Int, power: Int) extends Comparable[Pow] {
    override def compareTo(o: Pow): Int = (Math.log(o.p)*o.power).compareTo(Math.log(p)*power)

    def value = BigInt(p).modPow(BigInt(power), BigInt(500500507))
  }
  val a = mutable.PriorityQueue[Pow]() ++= Euler.primeList(10000000).toList.map(Pow(_, 1)).toTraversable

  var prod = BigInt(1)
  for (i <- 1 to 500500) {
    val e = a.dequeue()
    a += Pow(e.p, e.power*2)
    prod *= e.value
    prod %= BigInt(500500507)
  }
  println(prod)
}
