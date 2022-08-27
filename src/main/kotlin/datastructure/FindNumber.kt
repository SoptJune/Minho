package datastructure

fun main() {
    val N = readln().toInt()
    val A = HashMap<Int,Int>()
    readLine()?.split(' ')?.map { it.toInt() }?.forEach {
        A[it] = 1
    }
    val M = readln().toInt()
    readLine()?.split(' ')?.map { it.toInt() }?.forEach {
        println(A[it]?:0)
    }
}