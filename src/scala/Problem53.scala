package scala

object Problem53 extends App {
  def fact(n: Int) = (BigInt(1) to BigInt(n)).product
  def binomial(n: Int, r: Int) = fact(n) / (fact(r)*fact(n-r))

  println((for(n <- 1 to 100; r <- 1 to n) yield binomial(n, r)).count(x => x > 1000000))
}
