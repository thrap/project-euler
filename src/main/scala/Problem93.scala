package scala

object Problem93 extends App {
  def parseList(arr: List[Int]) = {
    def parse(start: Int, end: Int): Set[Rational] = {
      if (start == end)
        return Set[Rational](new Rational(arr(start)))

      var ret = Set[Rational]()
      for (i <- start until end) {
        val left = parse(start, i)
        val right = parse(i+1, end)

        for (a <- left; b <- right)
          ret++=(if (b.n == BigInt(0)) Set(a, b) else Set(a + b, a - b, a * b, a / b))
      }
      ret
    }
    parse(0,3)
  }

  val result = for(a <- 1 to 10; b <- a+1 to 10; c <- b+1 to 10; d <- c+1 to 10) yield {
    val possibleValues = List(a, b, c, d).permutations.flatMap(parseList)
    val integers = possibleValues.filter(_.d == BigInt(1)).map(_.n).toSet
    (""+a+b+c+d, Stream.from(1).takeWhile(integers.contains(_)).size)
  }
  println(result.maxBy(_._2)._1)
}
