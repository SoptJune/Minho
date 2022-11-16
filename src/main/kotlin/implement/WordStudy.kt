package implement

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().uppercase()
    val charArray = IntArray(26) { 0 }

    str.forEach {
        charArray[it.minus('A')]++
    }
    var maxValue = 0
    charArray.forEach {
        maxValue = max(it, maxValue)
    }
    val maxChar = (charArray.indexOf(maxValue).let {
        (it + 65).toChar()
    })
    charArray[(maxChar - 65).toInt()] = 0
    if (charArray.indexOf(maxValue) == -1) {
        println(maxChar)
    } else {
        println("?")
    }
}