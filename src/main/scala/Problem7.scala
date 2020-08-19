package scala

import utils.Euler

object Problem7 extends App{
  def f(n:Int, a:Int):Int = if (Euler.isPrime(a)) if(n == 1) a else f(n-1, a+1) else f(n, a+1)
  print(f(10001, 2))
}
