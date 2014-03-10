package scala

object Problem28 extends App {
  println((for (x <- 3 to 1001 by 2; i <- 0 to 3) yield x*x-(x-1)*i).sum+1)
}
