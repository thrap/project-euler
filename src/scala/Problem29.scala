package scala

object Problem29 extends App {
  print((for(a <- 2 to 100; b <- 2 to 100) yield BigInt(a).pow(b)).toSet.size)
}
