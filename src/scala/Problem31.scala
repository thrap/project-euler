package scala

object Problem31 extends App {
  val nums = Array.fill(201){0}
  val coins = List(1,2,5,10,20,50,100,200)
  for (coin <- coins) {
    nums(coin) += 1
    for (i <- coin until nums.length)
      nums(i) += nums(i-coin)
  }
  println(nums(200))
}
