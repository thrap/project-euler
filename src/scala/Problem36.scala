package scala

object Problem36 extends App {
  def p(s: String) = s.reverse.equals(s)
  println((1 until 1000000).filter(i => p(""+i) && p(Integer.toBinaryString(i))).sum)
}
