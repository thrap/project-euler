package thrap.euler

import kotlin.math.floor
import kotlin.math.log
import kotlin.math.log10
import kotlin.math.pow

fun main() {
    fun p(L: Int, n: Int): Int {
        val digits = "$L".length
        var count = 0

        for (j in generateSequence(0){ it + 1 }) {
            val x = j * log(2.0, 10.0);
            val y = floor(10.0.pow(x - floor(x) + digits - 1)).toInt();
            if (y == L) {
                count++
                if (count == n) {
                    println("p(123, 45) = $j")
                    return j
                }
            }
        }
        return -1
    }

    p(123, 45)
}