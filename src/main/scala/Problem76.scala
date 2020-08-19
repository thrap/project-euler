package scala

object Problem76 extends App {
  val p = Array.fill(101){1L}
  for (n <- 2 to 99; i <- n until p.length)
    p(i) += p(i-n)
  println(p(100))
}
