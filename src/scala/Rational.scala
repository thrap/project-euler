package scala

class Rational(numerator: BigInt, denominator: BigInt) {
  def this(n: BigInt) = this(n,1)

  private val gcd: BigInt = gcd(numerator, denominator)
  val n = (numerator*denominator).signum * numerator.abs / gcd
  val d = denominator.abs / gcd

  def + (r: Rational): Rational =
    new Rational(n * r.d + r.n * d, d * r.d)

  def - (r: Rational): Rational =
    new Rational(n * r.d - d * r.n, d * r.d)

  def * (r: Rational): Rational =
    new Rational(n * r.n, d * r.d)

  def / (r: Rational): Rational =
    * (new Rational(r.d, r.n))

  def < (r: Rational): Boolean =
    n * r.d < d * r.n

  def == (r: Rational): Boolean =
    n == r.n && d == r.d

  private def gcd(a: BigInt, b: BigInt): BigInt =
    if (b == BigInt(0)) a.abs else gcd(b, a % b)

  override def toString: String = {
    if (d == BigInt(1)) "" + n else "" + n + "/" + d
  }

  override def equals(obj:Any) =
    obj.isInstanceOf[Rational] && obj.asInstanceOf[Rational] == this

  override def hashCode = (n*d).hashCode()
}
