package scala

object Problem26 extends App {
  def period(n: Int): Int = {
    if (n % 2 == 0) return period(n / 2)
    if (n % 5 == 0) return period(n / 5)
    if (n == 1) return 0
    def _period(k: Int) : Int = if (k % n != 1) 1 + _period((k*10) % n) else 1
    _period(10)
  }

  println((2 until 1000).maxBy(period))
}
