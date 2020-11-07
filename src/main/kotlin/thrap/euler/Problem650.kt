package thrap.euler

import utils.Euler
import utils.T
import java.math.BigInteger
import java.math.BigInteger.*
import java.util.HashMap

fun main() {

    val t = T()
    println(S(2, 2) * S(5, 4))

    println(D(5))
    println(D(10))

    println(S(10))
    println(S(100).mod((1000000007).toBigInteger()))
    println(332792866)

    println(S(2000).mod((1000000007).toBigInteger()))
    println(939425731)
    println(t)

}

private typealias Factors = Map<Int, Int>

private fun List<Factors>.product(): Factors {
    return reduce { acc, map -> acc * map }
}

private fun Factors.pow(k: Int): Factors {
    return mapValues { (_, j) -> j*k }
}

operator fun Factors.times(factors: Factors): Factors {
    val res = HashMap<Int, Int>(this)
    for ((p, k) in factors) {
        res[p] = (res[p]?:0) + k
    }
    return res
}

fun S(n: Int): BigInteger = (n downTo 3).sumOf { k -> D(k) } + (4).toBigInteger()

fun D(n: Int): BigInteger {
    // (n!)^(n-1)
    val numerator: Factors = (2..n).map { factors(it) }.product().pow(n-1)

    //HELE DENNE KAN REDUSERES SOM JULING
    // (n-1)^2 * (n-2)^4 * (n-3)^6 * ... * 2^(2*(n-2))
    val denominator = ((n - 1) downTo 2).mapIndexed { index, i -> factors(i).pow((index + 1) * 2) }.product()

    if (n == 10) {
        println(numerator)
        println(denominator)
        println(numerator.mapValues { (p, k) -> k - (denominator[p] ?: 0)})
    }

    return numerator.entries.fold(ONE) { acc, (p, k) -> (acc * S(p, k - (denominator[p] ?: 0))) % (1000000007).toBigInteger()}
}


private fun S(p: Int, k: Int): BigInteger = S(p.toBigInteger(), k.toBigInteger())

private fun S(p: BigInteger, k: BigInteger): BigInteger = (p.modPow(k + ONE, (1000000007).toBigInteger()*(p-ONE)) - ONE)/(p - ONE)

private val primeFactorMap = HashMap<Int, Map<Int, Int>>()

private fun factors(i: Int): Factors {
    if (primeFactorMap[i] != null)
        return primeFactorMap[i]!!
    val map = Euler.primeFactorMap(i)
    primeFactorMap[i] = map
    return map
}