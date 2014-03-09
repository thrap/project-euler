package scala

object Problem92 extends App {
  def endsWith89(n: Int): Boolean = {
    if(n == 1 || n == 89) n == 89 else endsWith89((""+n).foldLeft(0)((accu, x) => x.asDigit*x.asDigit+accu))
  }
  println((1 to 10000000).count(endsWith89))
}
