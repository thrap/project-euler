package scala
import utils.Euler

import scala.jdk.CollectionConverters.CollectionHasAsScala

object Problem10 extends App{
  println(Euler.primeList(2000000).asScala.map(_.toInt).foldLeft(0L)(_+_))
}
