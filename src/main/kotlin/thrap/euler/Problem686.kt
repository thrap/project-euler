package thrap.euler

import kotlin.math.floor
import kotlin.math.log
import kotlin.math.pow

fun main() {
    fun p(L: Int, n: Int): Int {
        val digits = "$L".length

        tailrec fun rec(j: Int, count : Int): Int =
            if (count == n)
                j - 1
            else {
                val x = j * log(2.0, 10.0);
                val y = floor(10.0.pow(x - floor(x) + digits - 1)).toInt();

                rec(j+1, count + if (y == L) 1 else 0)
            }

        return rec(1, 0)
    }

    println(p(123, 45))
}