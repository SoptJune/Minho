package datastructure

import java.io.BufferedWriter
import java.io.OutputStreamWriter

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