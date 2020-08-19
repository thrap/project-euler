package scala

object Problem1 {
  def main(args: Array[String]) {
    println((1 to 999).filter(x => x%5 == 0 || x%3 == 0).sum)
  }
}
