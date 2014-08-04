package scala

object Problem30 extends App {
  def sum(n: Long): Long = {
    if (n == 0) 0 else Math.pow(n % 10, 5).toLong + sum(n / 10)
  }
  println((2L to 1000000L).filter(x => x == sum(x)).sum)
}
