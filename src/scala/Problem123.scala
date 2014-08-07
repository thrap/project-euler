package scala

import utils.Euler
import scala.collection.JavaConversions._

object Problem123 extends App {
  Euler.primeList(1000000).toList.map(BigInt(_)).zip(Stream from 1).find{
    case (p, n) => ((p-1).modPow(n, p*p) + (p+1).modPow(n, p*p)) % (p*p) > BigInt(10).pow(10)
  }.foreach{case (_, n) => println(n)}
}
