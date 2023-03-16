package datastructure

import java.util.LinkedList

fun main() {
    println(solution(2, 10, intArrayOf(7, 4, 5, 6)))
    println(solution(100, 100, intArrayOf(10)))
    println(solution(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
    println(solution(5, 5, intArrayOf(2, 2, 2, 2, 1, 1, 1, 1, 1)))

}

/*
    연결 리스트의 최대 길이 bridgeLength
    연결 리스트 최대 합 weight
    최대 시간 (truckWeights.size * 2) + 1
    큐가 비어있다면, 다음꺼 바로 넣는다
    큐가 비어있지 않다면,
    전체 합 + 다음꺼가 weight를 넘는지 체크
    넘는다면, bridgeLength만큼 보낸다.
    안 넘는다면, 큐에 추가
    그럼 각각 bridgeLength를 건너는 시간을 어떻게 구할까?
 */
private fun solution(bridgeLength: Int, weight: Int, truckWeights: IntArray): Int {
    val queue = LinkedList<Int>()
    var i = 0
    var sum = 0
    truckWeights.forEach { truck ->
        while (true) {              //다리를 건너는 동안을 while문으로 감싸놓음
            if (queue.size == bridgeLength) {   //다리에 0이든 트럭이든 다 채워져 있을 때 마다 비움
                sum -= queue.poll()
            } else if (queue.isEmpty()) {       //다리에 암것도 없으면 냅다 넣기
                sum = truck                     //현재 큐의 sum 은 다른 변수에 저장해둔다.
                queue.offer(truck)              //큐 추가
                i++                             //시간 추가
                break
            } else {
                if (sum + truck <= weight) {    //큐 추가해도 weight 안 넘을 때만 추가
                    sum += truck                //누적합 추가
                    queue.offer(truck)          //큐 추가
                    i++                         //시간 추가
                    break
                } else {                        //어차피 여기까지 온다는 건 현재 큐에 추가를 해야하는데 못 넣는 상황 -> 큐를 비워야 함 -> 다리 위에 있는 트럭을 보내야함
                    queue.offer(0)           //큐가 비워져 있지 않다는건 트럭이든 뭐든 있을테니 냅다 추가
                    i++                         //시간 추가요
                }
            }
        }
    }
    /*while (i <= (truckWeights.size * bridgeLength)) {
        if (idx == truckWeights.size) {
            if (queue.isEmpty()) {
                return i
            } else {
                return i + bridgeLength
            }
        }
        if (queue.isEmpty()) {
            sum = truckWeights[idx]
            queue.offer(truckWeights[idx++])
            i++
        } else if (sum + truckWeights[idx] <= weight) {
            sum += truckWeights[idx]
            queue.offer(truckWeights[idx++])
            i++
        } else {
            sum -= queue.poll()
            i++
        }
        println("$queue i : $i")
    }*/
    return i + bridgeLength
}