package scala

import utils.Euler

object Problem12 extends App {
  println(Stream.from(1).map(n => (n*(n+1))/2).dropWhile(Euler.divisorAmount(_) < 500).head)
}
