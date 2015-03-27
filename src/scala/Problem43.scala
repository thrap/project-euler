package scala

object Problem43 extends App {
  val primes = List(2,3,5,7,11,13,17)
  def hasProperty(v: Seq[Long]) =
    (1 to 7).forall(i => v.slice(i, i + 3).reduce(10 * _ + _) % primes(i - 1) == 0)
  println((0L to 9L).permutations.filter(hasProperty).map(_.reduce(10L*_+_)).sum)
}
