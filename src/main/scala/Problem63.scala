package scala

object Problem63 extends App {
  println((1 to 30).map(p => (1 to 9).count(BigInt(_).pow(p).toString.length == p)).sum)
}
