package scala

object Problem28 extends App {
  println((for (x <- 3 to 1001 by 2) yield 4*x*x-(x-1)*6).sum+1)
}
