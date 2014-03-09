package scala

object Problem14 extends App {
  def f(n:Long, count:Int):Int = {
    if(n == 1) count else if(n % 2 == 0) f(n/2, count+1) else f(3*n+1, count+1)
  }
  print((1 until 1000000).map(x => (x, f(x,1))).maxBy(_._2))
}
