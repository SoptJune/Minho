package math

/*
    백분 17427 약수의 합2(실버 2)
*/
private lateinit var array: IntArray

fun main() {
    val N = readln().toInt()
    array = IntArray(N) {
        it + 1
    }
    val sumGx = LongArray(N + 1)
    array.forEach {
        sumGx[it] = (it * (N / it)).toLong()
    }
    print(sumGx.sum())
}

private fun divisorSum(num: Int): Long = array.filter { divideNum -> num % divideNum == 0 }.sum().toLong()
