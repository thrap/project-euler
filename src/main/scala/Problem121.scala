package scala

import utils.Euler

object Problem121 extends App {
  val turns = 15

  def isWinner(s: String) = s.count(_ == '1') > turns/2

  val ans = (0 until Math.pow(2, turns).toInt).map(Euler.toBinaryString(_, turns)).filter(isWinner).map(binary => {
    val n = (0 until turns).filter(i => binary(i) == '0').map(i => BigInt(i + 1)).product
    val d = (0 until turns).map(i => BigInt(i + 2)).product
    new Rational(n, d)
  }).reduce(_ + _)

  println(ans.d / ans.n)
}
