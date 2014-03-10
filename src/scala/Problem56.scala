package scala

object Problem56 extends App {
  println((for(a <- 1 to 99; b <- 1 to 99) yield BigInt(a).pow(b))
    .map(_.toString().map(_.asDigit).sum).max)
}
