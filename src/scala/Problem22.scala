package scala

import scala.io.Source._

object Problem22 extends App {
  var names = fromFile("src/input-files/p22.txt").getLines().next().replace("\"","").split(",").sorted
  println(names.map(name => name.map(_-'A'+1).sum).zipWithIndex.map(x => x._1*(x._2+1)).sum)
}