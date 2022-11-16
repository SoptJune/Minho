package greedy

fun main() {

    println("${solution(100000, intArrayOf(2), intArrayOf(2))}")

}

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    val mutableReserve = reserve.sorted().subtract(lost.toSet()).toMutableSet()
    val mutableLost = lost.sorted().subtract(reserve.toSet()).toMutableSet()
    val result = mutableLost.filter { value ->
        if (mutableReserve.contains(value - 1)) {
            mutableReserve.remove(value - 1)
            false
        } else if (mutableReserve.contains(value + 1)) {
            mutableReserve.remove(value + 1)
            false
        } else {
            true
        }
    }
    return n - result.size
}