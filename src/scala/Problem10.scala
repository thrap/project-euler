package scala

import utils.Euler
import scala.collection.JavaConversions._

object Problem10 extends App{
  println(Euler.primeList(2000000).toList.map(_.toInt).foldLeft(0L)(_+_))
}
