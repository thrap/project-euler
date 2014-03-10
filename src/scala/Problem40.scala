package scala

object Problem40 extends App {
  val str = (0 to 1000000).mkString.map(_.asDigit)
  println((0 to 6).map(x => str(math.pow(10,x).toInt)).product)
}
