package scala

object Problem114 extends App {
  var cache = Array.fill[Long](100)(0)

  def count(tiles: Int, width: Int): Long = {
    if (cache(width) != 0)
      return cache(width)

    cache(width) = (
      for (blanks <- 1 to tiles - width; blocks <- 3 to tiles - blanks - width)
        yield 1 + count(tiles, width + blocks + blanks)
      ).sum
    cache(width)
  }

  println(count(51,0)+1)

}
