package scala

object Problem122 extends App {
  val limit = 200
  var shortest = Array.fill(limit+1){Int.MaxValue}
  var path = Array.fill(limit+1){0}

  def recur(power:Int, depth:Int):Unit = {
    if (power > limit || depth > shortest(power))
      return
    shortest(power) = depth
    path(depth) = power
    for (i <- (0 to depth).reverse)
      recur(power + path(i), depth+1)
  }
  recur(1,0)
  println(shortest.tail.sum)
}
