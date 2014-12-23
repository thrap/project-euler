package scala

object Problem491 extends App {
  val nums = 10

  var map = Map[String, Int]()
  def recur(n:Int, sum:Int, list:List[Int]):Unit = {
    if (list.size == nums) {
      map += (list.reverse.mkString -> sum)
    }
    for (num <- Math.max(0, 2+nums-2*(nums-n)-list.sum) to Math.min(2,nums-list.sum)) {
      recur(n+1, sum + num * n, num :: list)
    }
  }
  recur(0, 0, List())

  def fac(n:Long) = (1L to n).product

  var count = 0L
  for (key <- map.keys) {
    val inverse = key.map(2-_.toInt+'0').mkString

    if ((map(key) - map(inverse)) % 11 == 0) {
      val denom = Math.pow(2, key.count(_ == '2')).toInt
      val last = fac(nums)/denom
      var first = fac(nums)/denom

      if (key(0) == '1')
        first -= fac(nums-1)/denom
      else if (key(0) == '2') {
        first -= 2*fac(nums-1)/denom
      }
      count += first * last
    }
  }
  println(count)
}
