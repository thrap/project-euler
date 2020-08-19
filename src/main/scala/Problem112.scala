package scala

object Problem112 extends App {
  def increasing(s: String) =
    s.sorted == s

  def decreasing(s: String) =
    s.sorted.reverse == s

  def bouncy(n: Int) =
    !(increasing(n.toString) || decreasing(n.toString))

  def ans(n: Int, count: Int): Int =
    if (count*100 == (n-1)*99)
      n-1
    else
      ans(n+1, count + (if(bouncy(n)) 1 else 0))

  println(ans(2,0))
}
