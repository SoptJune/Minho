package datastructure

import java.io.BufferedWriter
import java.io.OutputStreamWriter

/*
    백준 10816번 (숫자 카드 2)
    해시 맵 사용
    첫째 줄에 입력으로 주어진 M개의 수에 대해서,
    각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
    뭐 없다.
 */

fun main() {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = readln().toInt()
    val A = HashMap<Int,Int>()
    readLine()?.split(' ')?.map { it.toInt() }?.forEach {
        A[it] = (A[it] ?: 0) + 1
    }
    val M = readln().toInt()
    val str = StringBuilder()
    readLine()?.split(' ')?.map { it.toInt() }?.forEach {
        str.append("${A[it]?:0} ")
    }
    bw.write(str.toString())
    bw.close()
}