package scala

object Problem491BaseCase extends App {
  val nums = 5
    println(List(0 until nums, 0 until nums).flatten.permutations.filter(_(0) != 0).map(_.foldLeft(0L)(10*_+_)).count(_ % 11 == 0))
}
