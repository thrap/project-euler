package scala

object Problem52 extends App {
  print(Stream.from(1).dropWhile(x => (1 to 6).map(i => (i*x).toString.sorted).toSet.size!=1).head)
}
