package scala

object Problem15 extends App {
  def fact(n:Long):BigInt = if (n == 1) 1 else n*fact(n-1)
  println(fact(40)/fact(20).pow(2))
}
