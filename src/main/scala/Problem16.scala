package scala

object Problem16 extends App {
  println(BigInt(2).pow(1000).toString().map(_-'0').sum)
}
