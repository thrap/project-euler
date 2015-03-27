package scala

import utils.Euler
import scala.collection.JavaConversions._

object Problem77 extends App {
  val nums = Array.fill(1000){0L}
  val coins = Euler.primeList(1000).toList.map(_.toInt)
  for (coin <- coins) {
    nums(coin) += 1
    for (i <- coin until nums.length)
      nums(i) += nums(i-coin)
  }
  println(nums.zipWithIndex.find(_._1 > 5000).get._2)
}
