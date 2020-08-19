package scala

import utils.Euler

object Problem118 extends App {
  def parse(s: String, set: Set[Int]): Set[Set[Int]] = {
    if (s.isEmpty)
      Set(set)
    else {
      val primes = (1 to s.length).map(i => (s.take(i).toInt, s.drop(i))).filter(t => Euler.isPrime(t._1))
      primes.map{case (p, rest) => parse(rest, set+p)}.toSet.flatten
    }
  }

  println((1 to 9).mkString("").permutations.map(s => parse(s, Set())).toSet.flatten.size)
}
