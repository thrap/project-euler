package scala

object Problem85 extends App {
  val candidates = for (x <- 1 to 100; y <- 1 to 100) yield (x*y, ((x*(x+1))/2)*(y*(y+1))/2)
  println(candidates.minBy(x => Math.abs(2000000-x._2))._1)
}
