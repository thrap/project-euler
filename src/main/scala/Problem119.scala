package scala

object Problem119 extends App {
  def digitSum(n: BigInt): BigInt = if (n==0) 0 else n%10 + digitSum(n/10)

  val limit = BigInt(10).pow(30)

  val a = (for(k <- BigInt(2) to BigInt(1000); p <- 2 to 100 if k.pow(p) < limit)
    yield (k, p)).filter{case (k, p) => digitSum(k.pow(p)) == k}
    .map{case (k, p) => k.pow(p)}.sorted

  println(a(30-1))
}
