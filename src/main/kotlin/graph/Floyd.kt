package graph

import java.math.BigInteger

fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val array = List(N) { y ->
        MutableList<BigInteger>(N) { x ->
            if (y == x) {
                BigInteger.ZERO
            } else {
                BigInteger.valueOf(Int.MAX_VALUE.toLong()*3)
            }
        }
    }

    repeat(M) {
        readln().split(" ").map { it.toInt() }.run {
            array[this[0] - 1][this[1] - 1] = array[this[0]-1][this[1]-1].coerceAtMost(BigInteger.valueOf(this[2].toLong()))
        }
    }
    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                array[i][j] = (array[i][j]).coerceAtMost(array[i][k] + array[k][j])
            }
        }
    }

    array.forEach {
        println(it.toList().joinToString(" ").replace((Int.MAX_VALUE.toLong()*3).toString(), "0"))
    }
}