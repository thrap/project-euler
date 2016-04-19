package scala

import utils.Euler
import scala.collection.JavaConversions._

object Problem555 extends App {
  def SF(m: Long, k: Long, s: Long): Long = {
    ((m+1-s) to m-s+k-s).sum
  }

  def S(p: Long, m: Long) = {
    (
      for {
        s <- 1L until p
        k <- Euler.divisorList(s).map(_ + s).filter(_ <= p)
      } yield SF(m, k, s)
    ).sum + p
  }

  println(S(1000000, 1000000))
}
