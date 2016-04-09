package scala

object Problem551BaseCase extends App {
  def d(n: Long): Long = {
    if (n == 0) 0 else n % 10 + d(n / 10)
  }

  def a(acc: Long, i: Int): Long = {
    if (i == 1) acc else a(acc + d(acc), i - 1)
  }

  println(a(1, 1000000))
}
