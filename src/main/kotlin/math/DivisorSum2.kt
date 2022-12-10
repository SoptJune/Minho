package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter

/*
    백준 17425 약수의 합(골드 4)
 */

private lateinit var array: IntArray
private lateinit var arrayMap: LongArray
fun main() {
    val N = readln().toInt()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()

    array = IntArray(N) {
        readln().toInt()
    }
    arrayMap = LongArray(array.max() + 1)
    divisor(array.max())
    array.forEach {
        str.append("${arrayMap[it]}\n")
    }
    bw.write(str.toString())
    bw.close()
}

fun divisor(max: Int) {
    for (i in 1..max) {
        for (j in 1..max / i) {
            arrayMap[(i * j)] += j.toLong()
        }
        arrayMap[i] += arrayMap[i - 1]
    }
}

/*
2

 */
