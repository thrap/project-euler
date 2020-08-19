package thrap.euler

import kotlin.math.floor
import kotlin.math.log
import kotlin.math.log10
import kotlin.math.pow

fun main() {
    tailrec fun p(L: Int, n: Int, j: Int = 1, count: Int = 0): Int {
        if (count == n)
            return j - 1

        val digits = "$L".length

        val x = j * log(2.0, 10.0);
        val y = floor(10.0.pow(x - floor(x) + digits - 1)).toInt();

        return p(L, n, j + 1, count + if (y == L) 1 else 0)
    }

    println(p(123, 45))
}