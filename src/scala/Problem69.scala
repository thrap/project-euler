package scala

import utils.Euler

object Problem69 extends App {
  println((1 to 1000000).maxBy(n => n.toDouble/Euler.phi(n)))
}
