package scala

object Problem62 extends App {
  println((1 to 10000).map(""+BigInt(_).pow(3))
    .groupBy(_.sorted).filter(x => x._2.size == 5)
    .map(_._2).flatten.min)
}
