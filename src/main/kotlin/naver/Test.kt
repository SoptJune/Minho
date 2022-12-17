package naver

import java.util.PriorityQueue

/*
구현 2  dfs bfs 1 문자열1 greedy1
다이젝스트라랑 DP도 풀면 좋음, 구현 문제 많이 나옴

시간복잡도 계산하면 유형 나옴

N>10만정도로 넘어가면 이분탐색, 다이젝스트라, 정렬, 크루스칼 중 하나
다이젝스트라는 pq로, pq에 Comparator 잘 넣어라

누적합도 가끔 나옴

문자열, Random, Graph 나올 것 같음

문자열은 KMP까지는 절대 안 나올듯

중복 허용 관련 꼭 체크하기

머리로 안 풀리는건 완전 탐색
n범위 1000 이하면 그냥 완전 탐색, 100이하는 n^3도 괜춘
n범위 15이하는 순열 조합, 백트래킹이라 완전탐색

union find, [0,1,-1,0], 백트래킹, dfs, bfs도 기본 틀 요런건 만들어두기

 */

fun main() {
    val test = Test()
    //test.solution1("RLDU")
    /*test.solution2(
        arrayOf(
            intArrayOf(1, 1, 5, 3),
            intArrayOf(2, 2, 3, 3),
            intArrayOf(1, 1, 4, 4),
            intArrayOf(1, 0, 3, 6),
            intArrayOf(0, 2, 5, 3)
        ),
        intArrayOf(3, 2, 5)
    )*/
    println(
        test.solution3(
            arrayOf(
                intArrayOf(66000, 0, 50),
                intArrayOf(16000, 2, 10),
                intArrayOf(84500, 3, 20),
                intArrayOf(5500, 2, 75)
            )
        )
    )
    println(
        test.solution3(
            arrayOf(
                intArrayOf(100, 0, 50),
                intArrayOf(1000, 0, 50),
                intArrayOf(10000, 0, 50),
            )
        )
    )
}

class Test {

    private val intRangeX = intArrayOf(0, 0, 1, -1)
    private val intRangeY = intArrayOf(1, -1, 0, 0)
    private lateinit var unionFind: IntArray


    fun solution2(gates: Array<IntArray>, airlines: IntArray) {
        val maxAirlines = airlines.max()
        val sumAirlines = airlines.sum()
        val answer = mutableListOf<Int>()
        gates.forEachIndexed { index, gate ->
            var isPossible = true
            if (gate.max() > maxAirlines) {// 적어도 하나 못함
            } else if (gate.sum() > sumAirlines) { //끝까지 다 못함
            } else {
                val tempAirLines = airlines.sorted().toMutableList()

                val visit = BooleanArray(gate.size)
                val filterGate = gate.filter { it != 0 }.sorted()
                gate.forEachIndexed { index, i ->
                    val dfsMap = tempAirLines.filter { it >= i }
                    dfsMap.forEach {
                        findDfs(visit, tempAirLines, index, filterGate)
                    }
                }
                tempAirLines.forEachIndexed { index, i ->
                }
                gate.forEach {
                    if (tempAirLines[0] >= it) {
                        tempAirLines[0] -= it
                    } else if (tempAirLines[1] >= it) {
                        tempAirLines[1] -= it
                    } else if (tempAirLines[2] >= it) {
                        tempAirLines[2] -= it
                    } else {
                        isPossible = false
                    }
                }
                if (isPossible) {
                    answer.add(index + 1)
                }
            }
            intArrayOf(-1)
        }
        println(answer)
    }

    fun findDfs(visit: BooleanArray, tempAirLines: MutableList<Int>, index: Int, filterGate: List<Int>) {
        visit[index] = true

    }

    fun findZero(s: String): Boolean {

        var currentPositionX = 0
        var currentPositionY = 0
        s.forEach {
            when (it) {
                'R' -> {
                    currentPositionX += 1
                }
                'L' -> {
                    currentPositionX -= 1
                }
                'U' -> {
                    currentPositionY -= 1
                }
                'D' -> {
                    currentPositionY += 1
                }
            }
        }
        println("x $currentPositionX y $currentPositionY $s")
        return (currentPositionX == 0 && currentPositionY == 0)
    }

    private fun DFSSearch(currentX: Int, currentY: Int, level: Int) {

        for (i in 0 until 4) {
            val dx = currentX + intRangeX[i]
            val dy = currentY + intRangeY[i]
            if (dx < 0 || dy < 0 || dx >= 5 || dy >= 5) continue //영역 침범했는지

            if (false) { // 특정 경우에만 이동하게
                DFSSearch(dx, dy, level)
            }
        }
    }


    fun solution3(games: Array<IntArray>): Int {
        var price = 0
        val pq =
            PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.second })
        val restpq = PriorityQueue<Triple<Int, Int, Int>>(
            compareByDescending { it.first * ((100 - it.third).toDouble() / 100) })
        repeat(games.size) { index ->
            val data = games.filter { it[1] == index }
                .sortedByDescending { it[0] - (it[0] * ((100 - it[2]).toDouble() / 100)) }
            /*if (data.size == games.size) {
                val data2 = data.map { (it[0] * (100 - it[2]) / 100.toDouble()).toInt() }
                println(data2)
                return data2.sum()
            }*/
            data.forEachIndexed { index, game ->
                if (index == 0) {
                    pq.offer(
                        Pair(
                            (game[0].toDouble() * ((100 - game[2]).toDouble() / 100)).toInt(),
                            game[1]
                        )
                    )
                } else {
                    restpq.offer(Triple(game[0], game[1], game[2]))
                }
            }
        }
        /*repeat(games.size){
            println("pq ${pq.poll()}")
            println("rest ${restpq.poll()}")
            println()
        }*/
        println(pq)
        println(restpq)
        repeat(games.size) {
            if (pq.peek() != null && pq.peek().second == it) {
                price += pq.poll().first
                while (restpq.peek() != null && restpq.peek().second == it) {
                    val temp = restpq.poll()
                    price += (temp.first.toDouble() * ((100-temp.third).toDouble()/100)).toInt()
                }
                println("Day $it")
            } else if(restpq.peek()!=null){
                println("Day Rest $it")
                price += restpq.poll().first
            }
        }
        // 3번 예시 2700 -> 2650 으로 수정
        return price
    }

    fun solution1(s: String) {
        var totalCount = 0
        for (i in s.indices) {
            for (j in i + 1..s.length) {
                if (findZero(s.substring(i, j))) {
                    totalCount++
                }
            }
        }
        println(totalCount)
    }

    private fun findParent(island: Int): Int {
        if (unionFind[island] == island) {
            return island
        } else {
            return findParent(unionFind[island])
        }
    }

    private fun unionCombine(first: Int, second: Int) {
        val node1 = findParent(first)
        val node2 = findParent(second)
        if (node1 < node2) {
            unionFind[node2] = node1
        } else {
            unionFind[node1] = node2
        }
    }

    private fun isParentSame(first: Int, second: Int) = findParent(first) == findParent(second)
}

