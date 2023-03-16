package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter
/*
    백준 9375번 (패션왕 신해빈)
    구현 풀이
    HashMap 사용
    종류들을 ++ 해놓고 곱셈으로 푼다.
 */

fun main() {
    val case = readln().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()
    for(i in 0 until case) {
        val hash = HashMap<String, Int>()
        val N = readln().toInt()
        if(N==0){
            str.append("0\n")
            continue
        }
        repeat(N) {
            val (wear, kind) = readln().split(" ")
            hash[kind] = hash[kind]?.plus(1) ?: 1
        }
        var result = 1
        hash.values.forEach {
            result*=(it+1)
        }
        str.append("${result-1}\n")
    }
    bw.write(str.toString())
    bw.close()
}