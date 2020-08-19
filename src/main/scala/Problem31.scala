package scala

object Problem31 extends App {
  val p = Array.fill(201){1L}
  for (n <- List(2,5,10,20,50,100,200); i <- n until p.length)
    p(i) += p(i-n)
  println(p(200))
}
