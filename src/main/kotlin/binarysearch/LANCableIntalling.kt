package binarysearch
/*
    랜선 자르기 백준 1654번
    K 랜던 갯수
    N 최종 랜선 갯수
    최대한 몇으로 잘라야 N에 충족하는 랜선의 길이가 나오는가?
    입국 심사랑 개비슷함
    특정 랜선 길이를 정해놓고, 각 값과 나누어 몇개 나오는지 센다.
    right, left는 그에 따라서 수정
 */

fun main() {
    val (K, N) = readln().split(" ").map { it.toInt() }
    var right = 2147483647.0
    var left:Double = 1.0
    var answer = 0
    var cnt = 0.0
    var mid = 0.0
    val array = ArrayList<Int>()
    repeat(K) {
        array.add(readln().toInt())
    }
    while (left <= right) {
        mid = ((left + right) / 2).toInt().toDouble()
        cnt = 0.0
        array.forEach {
            cnt += (it / mid).toInt()
        }
        if (cnt >= N) {
            answer = mid.toInt()
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(answer)
}