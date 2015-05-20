package scala

object Problem340 extends App {
  def S(a:Int, b:Int, c:Int):Int = {
    def F(n:Int):Int = {
      if (n > b)
        n-c
      else
        F(a + F(a + F(a + F(a + n))))
    }
    (0 to b).map(F).sum
  }

  print(S(50, 2000, 40))
}
