package scala

import scala.io.Source._

object Problem42 extends App {
  val words = fromFile("src/input-files/p42.txt").getLines().next().replace("\"", "").split(",")

  def wordValue(word: String) = word.foldLeft(0)((c, acc) => acc+(c-'A')+1)
  val triangles = (1 to 100).map(n => (n*(n+1))/2).toSet

  println(words.map(wordValue).count(triangles.contains))
}
