package scala

import utils.Euler
import scala.collection.mutable
import collection.JavaConversions._

object Problem5 extends App{
  var map = mutable.HashMap[Integer, Integer]()
  (2 to 20).map(Euler.primeFactorMap).foreach(x => x.foreach(x => if(!map.contains(x._1) || map(x._1) < x._2) map += (x._1 -> x._2)))
  var ans = 1
  map.foreach((x) => ans *= math.pow(x._1.doubleValue(), x._2.doubleValue()).toInt)
  print(ans)
}
