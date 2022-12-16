package string

import java.io.BufferedReader
import java.io.InputStreamReader

/*
    백준 1316번 (그룹 단어 체커)
    문자열 풀이
    동일한 문자가 연속 되어서가 아니라 떨어져서 나오면 그룹 단어가 아님
    N개의 문자열들의 그룹 단어가 되는 갯 출력
 */
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