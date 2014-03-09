package scala

object Problem39 extends App {
  def solutions(p:Int) = {
    (for(a <- 1 until p; b <- a until p-a) yield (a,b,p-a-b))
      .count(p => p._1*p._1 + p._2*p._2 == p._3*p._3)
  }
  print((1 to 1000).map(solutions).zipWithIndex.maxBy(_._1)._2+1)
}
