package scala

import utils.Euler

object Problem35 extends App {
  val isPrime = Euler.primeArray(1000000)
  val primes = isPrime.zipWithIndex.filter(_._1).map(_._2)

  def rotate(n: Int) = {
    n / 10 + Math.pow(10, Math.log10(n).toInt).toInt * (n % 10)
  }

  def isCircularPrime(p: Int) = {
    val rotationsNeeded = Math.log10(p).toInt+1
    def isCircular(p: Int, i: Int): Boolean = {
      if (i == rotationsNeeded)
        true
      else isPrime(p) && isCircular(rotate(p), i+1)
    }
    isCircular(p, 0)
  }

  println(primes.filter(isCircularPrime).length)
}
