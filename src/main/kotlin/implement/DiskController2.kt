package implement
import java.util.PriorityQueue
fun main() {
    println(solution(arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))))
}

private fun solution(jobs: Array<IntArray>): Int {
    var (end, count, index, answer) = intArrayOf(0, 0, 0, 0)
    val data = jobs.map { it[0] to it[1] }.sortedBy { it.first } //시작 시간 기준으로 정렬, 그 남자의 Pair 사랑
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) //끝나는 시간이 빠른 순으로 뽑아낼 것
    while (count < jobs.size) {
        while (index < data.size && data[index].first <= end) {//행하고 있는 작업이 끝나기전까지의 데이터를 싹 다 추가
            pq.add(data[index++])
        }
        if (pq.isEmpty()) { //작업이 다 끝나고도 뭐가 안 들어올 때 기다리고 있는 작업 시작 시점으로 Jump한다
            end = data[index].first
        } else { //끝나는게 빠른 것부터 처리한다. 그래야 총 대기 시간이 제일 적기 때문
            count++
            val value = pq.poll()
            answer += value.second + end - value.first //대기 시간 계산
            end += value.second  //작업이 끝나는 시간을 넣어준다
        }
    }
    return (answer / data.size) //총 대기시간 평균이니깐 나누기
}