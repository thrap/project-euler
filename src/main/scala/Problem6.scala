package scala

object Problem6 extends App {
  print(math.pow((1 to 100).sum,2).toLong-(1 to 100).map(x => x*x).sum.toLong)
}
