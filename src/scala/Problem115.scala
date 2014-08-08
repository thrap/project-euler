package scala

object Problem115 extends App {
  println(Stream from 50 find(n => {
    Problem114.count(n, 50) > 1000000
  }))
}
