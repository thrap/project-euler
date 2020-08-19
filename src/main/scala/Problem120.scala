package scala

object Problem120 extends App {
  def r(p: BigInt) =
    (BigInt(0) until 2*p).map(n => ((p-1).modPow(n, p*p) + (p+1).modPow(n, p*p)) % (p*p)).max

  println((BigInt(3) to BigInt(1000)).map(r).sum)
}
