package scala

import scala.io.Source._

object Problem98 extends App {
  val words = fromFile("src/input-files/p98.txt").getLines().next().replace("\"", "").split(",").toList
  val anagrams = words.groupBy(_.sorted).filter(_._2.size > 1)
  val squares = (1L to Math.pow(10, anagrams.map(_._1.length).max/2d).toLong).map(x => ""+x*x)


  def mapFits(word: String, square: String, map: Map[Char, Char]) =
    !(0 until word.length).exists(i => map(word(i)) != square(i))

  def isSquarePair(words :List[String], map: Map[Char, Char]) = {
    words.exists(w => {
      val other = w.foldLeft("")((acc, c) => acc + map(c))
      other(0) != '0' && squares.contains(other)
    })
  }

  def maxSquare(word: String) = {
    val words = anagrams(word.sorted).filter(_ != word)
    val temp = squares.filter(_.length == word.length).filter(_.toSet.size == word.toSet.size).filter(square => {
      val map = (for(i <- 0 until word.length) yield (word(i), square(i))).toMap

      mapFits(word, square, map) && isSquarePair(words, map)
    }).map(_.toLong)
    if (temp.isEmpty) 0L else temp.max
  }

  println(anagrams.flatMap(_._2).map(maxSquare).max)
}
