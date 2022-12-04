package binarysearch

fun main() {
    println( solution(3, intArrayOf(1, 2, 3)))
}

fun solution(n: Int, times: IntArray): Long {
    times.sort()
    var answer: Long = 0
    var left: Long = 0
    var right: Long = (times.last().toLong() * n.toLong())
    var mid: Long = 0

    while (left <= right) {
        var count: Long = 0
        mid = (left + right) / 2
        times.forEach { time ->
            count += mid / time
        }
        if (count >= n) {
            answer = mid
            right = mid - 1
        }else if(count< n){
            left = mid + 1
        }
    }
    return answer
}
/*
7, 10 2
14, 20 4
21, 28 6
*/
