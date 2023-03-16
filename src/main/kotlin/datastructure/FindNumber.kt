package datastructure

/*
    백준 1920번 (수 찾기)
    뭐 없음
    N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
    M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다
 */

fun main() {
    val N = readln().toInt()
    val A = HashMap<Int, Int>()
    readLine()?.split(' ')?.map { it.toInt() }?.forEach {
        A[it] = 1
    }
    val M = readln().toInt()
    readLine()?.split(' ')?.map { it.toInt() }?.forEach {
        println(A[it] ?: 0)
    }
}