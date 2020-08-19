package scala

object Problem78 extends App {
  val p = Array.fill(60001){1L}
  val nums = 2 to 60000
  for (n <- nums; i <- n until p.length) {
    p(i) += p(i-n)
    p(i) %= 1000000
  }
  println(p.zipWithIndex.find(_._1 == 0L).get._2)
}
