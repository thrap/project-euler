package scala

object Problem97 extends App {
  val mod = 1e10.toLong
  println((28433 * BigInt(2).modPow(7830457, mod) + 1) % mod)
}
