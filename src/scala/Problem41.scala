package scala

import utils.Euler

object Problem41 extends App {
  println((2 to 9).map(n => (1 to n).foldLeft("")((d, acc) => d+acc).permutations).flatten.map(_.toLong).filter(Euler.isPrime).max)
}
