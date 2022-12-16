package greedy

/*
    백준 9237번 (이장님 초대)
    그리디 풀이
    높은 순으로 정렬
    날이 지날수록 하루가 추가 되므로 day를 더해준다.
 */
fun main() {
    val N = readln().toInt()
    val array = readLine()?.split(' ')?.map { it.toInt() }?.sortedDescending()
    var day = 2
    var sum = 0
    array?.forEach {
        if (sum < it + day) {
            sum = it + day
        }
        day++
    }
    println(sum)
}