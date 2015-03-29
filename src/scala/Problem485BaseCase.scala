package scala

import utils.Euler

object Problem485BaseCase extends App {
  def d(n:Int) =
    Euler.divisorAmount(n)
  def M(n:Int, k:Int) =
    (n to n+k-1).map(d).max
  def S(u:Int, k:Int) =
    (1 to u-k+1).map(M(_,k)).sum

  println(S(1000,10))
}
