package scala

import utils.Euler

object Problem2 extends App{
  def sum(n:Int, s:Long):Long = if(Euler.fib(n) > 4e6) s else sum(n+3, s+Euler.fib(n))
  println(sum(3,0))
}
