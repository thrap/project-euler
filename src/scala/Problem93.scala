package scala

object Problem93 extends App {
  def parseList(arr: List[BigInt]) = {
    def parse(start: Int, end: Int): Set[Rational] = {
      if (start == end)
        Set[Rational](new Rational(arr(start)))
      else {
        var ret = Set[Rational]()
        for (i <- start until end) yield {
          val left = parse(start, i)
          val right = parse(i+1, end)

          for (a <- left; b <- right) yield
            ret++=(if (b.n == BigInt(0)) Set(a, b) else Set(a + b, a - b, a * b, a / b))
        }
        ret
      }
    }
    parse(0,3)
  }

  val result = for(a <- 1 to 10; b <- a+1 to 10; c <- b+1 to 10; d <- c+1 to 10) yield {
    val list = List(a, b, c, d).map(BigInt(_)).permutations.toList.map(parseList).flatten.toSet.filter(r => r.d == BigInt(1) && r.n > 0).map(_.n)
    (""+a+b+c+d, Stream.from(1).takeWhile(list.contains(_)).size)
  }

  println(result.maxBy(_._2))
}
