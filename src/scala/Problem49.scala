package scala

import utils.Euler

object Problem49 extends App {
  print((1000 to 9999).map(x => (0 to 2).map(x+_*3330))
    .filter(!_.exists(!Euler.isPrime(_)))
    .filter(_.map(_.toString.sorted).toSet.size == 1).last.mkString)
}
