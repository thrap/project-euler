package scala

object Problem555BaseCase extends App {
  def M(m: Int, k: Int, s: Int)(n : Int): Int = {
    if (n > m)
      n - s
    else
      M(m, k, s)(n + k - s)
  }

  def SF(m: Int, k: Int, s: Int) = {
    ((m - s) to m).filter(n => n == M(m,k,s)(n)).sum
  }

  def S(p: Int, m: Int) = {
    (for (s <- 1 to p; k <- s + 1 to p) yield SF(m, k, s)).sum
  }

  // [(m - n) / (k - s) + 1] * (k-s) = s
  println(S(1000, 1000))

  /**
    * M(n) = n:
    * m - s <= n <= m
    *
    *
    * n =
    * n + (k - s) * x > m
    * solve for x
    *
    *
    * x = j*(k-s) + n minste j der n + (k - s) * j > m
    *
    * j > (m - n) / (k - s)
    *
    * Ceil[(m - n) / (k - s)]
    */
}
