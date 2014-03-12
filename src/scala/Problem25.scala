package scala

object Problem25 extends App {
  def fib(Fn1:BigInt, Fn2:BigInt, n:Int):Int = {
    if (Fn2.toString().length >= 1000) n else fib(Fn2, Fn1+Fn2, n+1)
  }
  print(fib(0,1,1))
}
