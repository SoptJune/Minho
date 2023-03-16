package greedy
/*
    프로그래머스 체육복
    그리디 풀이
    Lost = 안 가져온 학생 - 여벌 옷 가져온 학생
    Reserve= 여벌 옷 가져온 학생 - 안 가져온 학생
    의 집합을 만들었음,
    Lost를 거치면서 해당 학생의 -1, +1 위치의 학생이 여벌 옷이 있으면 remove
    n - 남은 리스트.size를 하면 수업을 들을 수 있는 학생이 나온다.
 */

fun main() {

    println("${solution(100000, intArrayOf(2), intArrayOf(2))}")

}

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    val mutableReserve = reserve.subtract(lost.toSet()).sorted().toMutableSet()
    val mutableLost = lost.subtract(reserve.toSet()).sorted().toMutableSet()
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