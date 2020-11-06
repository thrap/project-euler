package thrap.euler

import utils.Euler
import utils.T
import java.math.BigInteger
import java.math.BigInteger.*
import java.util.HashMap

fun main() {

    val t = T()
    println(S(2, 2) * S(5, 4))

    val n = 5
    println(D(n))

    println(S(10))
    println(S(100).mod((1000000007).toBigInteger()))
    println(332792866)

    println(S(500))
    println(246899395470)
    println(t)
}

fun S(n: Int): BigInteger = (n downTo 1).sumOf { k -> D(k) }

fun S(p: Int, k: Int): BigInteger = S(p.toBigInteger(), k.toBigInteger())

// https://www.math.upenn.edu/~deturck/m170/wk3/lecture/sumdiv.html
fun S(p: BigInteger, k: BigInteger): BigInteger = (p.modPow(k + ONE, (1000000007).toBigInteger()*(p-ONE)) - ONE)/(p - ONE)

private fun D(n: Int): BigInteger {
    if (n % 100 == 0)
        println(n)
    val res = HashMap<Int, Int>()
    for (i in n downTo 0) {
        val a = facMap(n - i)
        val b = facMap(i)
        res.add(facMap(n)).subtract(a).subtract(b)
    }

    return res.entries.fold(ONE) { acc, (p, k) -> acc * S(p, k) } % (1000000007).toBigInteger()
}

val memo = HashMap<Int, Map<Int, Int>>()
private fun facMap(i: Int): Map<Int, Int> {
    if (memo[i] != null) {
        return memo[i]!!
    }
    val primeFactorMap = primeFactorMap((0..i).toList())
    memo[i] = primeFactorMap
    return primeFactorMap
}

private fun MutableMap<Int, Int>.subtract(a: Map<Int, Int>): MutableMap<Int, Int> {
    for((x, y) in a) {
        this[x] = (this[x]?:0) - y
    }
    return this
}

private fun MutableMap<Int, Int>.add(a: Map<Int, Int>): MutableMap<Int, Int> {
    for((x, y) in a) {
        if (y != 0)
            this[x] = (this[x]?:0) + y
    }
    return this
}

private fun Int.pow(k: Int): Long {
    return this.toBigInteger().pow(k).toLong()
}

fun primeFactorMap(numbers: List<Int>): MutableMap<Int, Int> {
    val factors: MutableMap<Int, Int> = HashMap()
    for (number in numbers) {
        val numberFactors = mutableMap(number)
        for ((key, value) in numberFactors) {
            if (factors.containsKey(key)) {
                factors[key] = value + factors[key]!!
            } else {
                factors[key] = value
            }
        }
    }
    return factors
}

val primeFactorMap = HashMap<Int, Map<Int, Int>>()

private fun mutableMap(i: Int): Map<Int, Int> {
    if (primeFactorMap[i] != null)
        return primeFactorMap[i]!!
    val map = Euler.primeFactorMap(i)
    primeFactorMap[i] = map
    return map
}
