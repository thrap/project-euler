package scala

object Problem114 extends App {

  def count(tiles: Int, min: Int): Long = {
    val cache = Array.fill[Long](tiles+2)(0)
    def count(tiles: Int, width: Int, min: Int): Long = {
      if (cache(width) != 0)
        return cache(width)
      cache(width) = (
        for (blanks <- 1 to tiles - width; blocks <- min to tiles - blanks - width)
          yield 1 + count(tiles, width + blocks + blanks, min)
        ).sum
      cache(width)
    }
    count(tiles+1,0, min)+1
  }

  println(count(50,3))

}
