package scala

object Problem479 extends App {
  def S(N:BigInt) = {
    val mod = BigInt(1000000007)
    def f(K:BigInt) = {
      ((K.pow(2)-1)*((BigInt(1) - K.pow(2)).modPow(N, mod * K.pow(2))-1))/K.pow(2)
    }
    (BigInt(1) to N).map(f).sum % mod
  }
  println(S(1000000))
}
