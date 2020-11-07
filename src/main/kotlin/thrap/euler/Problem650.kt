package thrap.euler

import utils.Euler
import utils.T
import java.math.BigInteger
import java.math.BigInteger.ONE

fun main() {
    val MOD = (1000000007).toBigInteger()

    fun sum(n: Int) = n*(n+1)/2

    fun count(p: Int, n: Int, acc: Int): Int {
        return if (acc <= n)
            (n/acc) * (n-1) - (n/acc * 2 * n - 2 * sum(n/acc) * acc) + count(p, n, acc * p)
        else
            0
    }

    fun Sd(p: BigInteger, k: BigInteger): BigInteger = (p.modPow(k + ONE, MOD * (p - ONE)) - ONE)/(p - ONE)

    fun Sd(p: Int, k: Int): BigInteger = Sd(p.toBigInteger(), k.toBigInteger())

    fun D(n: Int): BigInteger = Euler.primeList(n).fold(ONE) { acc, p -> (acc * Sd(p, count(p, n, p))) % MOD }

    fun S(n: Int): BigInteger = (n downTo 1).sumOf { k -> D(k) } % MOD

    val t = T()
    println(S(20000))
    println(t)
}