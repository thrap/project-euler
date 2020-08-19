package scala

import scala.io.Source._

object Problem22 extends App {
  println(fromFile("src/input-files/p22.txt").getLines().next()
    .replace("\"","").split(",")
    .sorted
    .map(name => name.map(_-'A'+1).sum)
    .zipWithIndex
    .map{ case(w, idx)=> w*(idx+1) }
    .sum)
}
