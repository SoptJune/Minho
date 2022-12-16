package binarysearch

/*
    입국심사
    입국심사를 기다리는 사람 수 n,
    각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times,
    모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return
    n	times	return
    6	[7, 10]	  28
    최대 시간을 right로 잡고
    mid를 예상한 후 그걸 time마다 나누면서 계산
    그럼 각 시간당 필요한 인원들이 나옴, n과 비교한다
    n보다 작으면 더 키워도 된다.
    n보다 크거나 같으면 되는지 더 줄여본다.
 */

fun main() {
    println(solution(3, intArrayOf(1, 2, 3)))
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
        } else if (count < n) {
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
