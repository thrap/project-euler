package scala

object Problem34 extends App {
  def sum(n: Int): Int = {
    if (n == 0) 0
    else (1 to n % 10).product + sum(n / 10)
  }
  println((10 to 100000).filter(n => n == sum(n)).sum)
}
