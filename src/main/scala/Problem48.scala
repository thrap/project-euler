package scala

object Problem48 extends App {
  val mod: BigInt = BigInt(10).pow(10)
  print((BigInt(1) to BigInt(1000)).map(x => x.modPow(x, mod)).sum.mod(mod))
}
