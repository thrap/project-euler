package scala

import utils.Euler

object Problem2 extends App{
  def sum(n:Int, s:Long):Long = {
    val fib = Euler.fib(n)
    if(fib > 4e6) s else sum(n+3, s+fib)
  }
  println(sum(3,0))
}
