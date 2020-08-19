package scala

import utils.Euler

import scala.jdk.CollectionConverters.MapHasAsScala

object Problem549 extends App {
  List(2,3,5,7,11).foreach(n => println((1 to 100).map(x => Euler.primeFactorMap(n*x).asScala(n))))
//  (2 to 100).map(n => Euler.primeFactorMap(n))
}
