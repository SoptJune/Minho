package string

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var count = 0
    for (i in 0 until n) {
        val charArray = IntArray(26) { 0 }
        var ch: Char? = null
        var isGroup = true
        readLine().toString().forEach {
            if (it == ch) {
                return@forEach
            } else if (charArray[it.minus('a')] == 1) {
                isGroup = false
            } else {
                charArray[it.minus('a')] = 1
                ch = it
            }
        }
        if (isGroup) {
            count++
        }
    }
    println(count)
}