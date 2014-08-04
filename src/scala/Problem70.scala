package scala

import utils.Euler

object Problem70 extends App {
  def isPerm(s1: Int, s2: Int) = s1.toString.sorted.equals(s2.toString.sorted)

  println((2 until 10000000).filter(n => isPerm(n, Euler.phi(n))).minBy(n => n.toDouble/Euler.phi(n)))
}
