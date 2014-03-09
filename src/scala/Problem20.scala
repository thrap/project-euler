package scala

object Problem20 extends App {
  println((BigInt(1) to BigInt(100)).product.toString().map(_.asDigit).sum)
}
