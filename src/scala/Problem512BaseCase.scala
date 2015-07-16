package scala

import utils.Euler

object Problem512BaseCase extends App {
  def f(n: Int): BigInt =
    (Euler.phi(n) * (BigInt(n).pow(n)-1)/(n-1)) % (n+1)

  def g(n: Int): BigInt =
    (2 to n).map(f).sum + 1

  println(g(100))
}
