package scala

object Problem9 extends App{
  println((for(a <- 1 to 1000; b <- a to 1000-a) yield List(a,b,1000-a-b))
    .find((x) => x(0)*x(0)+x(1)*x(1)==x(2)*x(2)).get.product)
}
