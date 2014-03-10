package scala

object Problem24Shorter extends App {
  println((0 to 9).permutations.drop(999999).next.mkString)
}
