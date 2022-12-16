package graph

/*
    프로그래머스 여행 경로
    DFS 풀이, 리스트 풀이
    ICN 공항에서 모든 공항 경로를 이동할 때 그 경로를 출력
    ICN에서 시작하는 경우들을 다 시작으로 DFS 돌려봄
    보낼 때 Start를 기입, 끝까지 갔을 때 end까지 더해서 경로 넣어버리기~
 */

fun main() {
    solution(
        arrayOf(
            arrayOf("ICN", "AAA"),
            arrayOf("ICN", "AAA"),
            arrayOf("ICN", "AAA"),
            arrayOf("AAA", "ICN"),
            arrayOf("AAA", "ICN"),
        )
    ).forEach {
        println(it)
    }
}

var answerRoot: Array<String>? = null

fun solution(tickets: Array<Array<String>>): Array<String> {

    val pairTickets = tickets.mapIndexed { index, ticket ->
        Triple(ticket[0], ticket[1], index)
    }.sortedWith(compareBy<Triple<String, String, Int>> { it.first }.thenBy { it.second })

    val travelMap = BooleanArray(tickets.size)
    pairTickets.filter { it.first == "ICN" }.forEach { root ->
        travelMap[root.third] = true
        dfsTravel(root, travelMap, pairTickets, mutableListOf(root.first))
        travelMap[root.third] = false
    }
    return answerRoot ?: arrayOf()
}

fun dfsTravel(
    root: Triple<String, String, Int>, //출발역, 도착역, index 값 Triple
    travelMap: BooleanArray,
    tickets: List<Triple<String, String, Int>>,
    answer: MutableList<String>
) {
    if (travelMap.all { it }) {
        answer.add(root.second)
        answerRoot =
            if (answerRoot == null || (answerRoot != null && answerRoot!!.size > answer.size)) answer.toTypedArray()
            else answerRoot
    }
    tickets.filter { it.first == root.second }.forEach { filterRoot ->
        if (!travelMap[filterRoot.third]) {
            travelMap[filterRoot.third] = true
            dfsTravel(root = filterRoot, travelMap = travelMap, tickets = tickets, answer = (answer+filterRoot.first).toMutableList())
            travelMap[filterRoot.third] = false
        }
    }
}

/*

arrayOf(
arrayOf("ICN", "A"), true
arrayOf("A", "B"),
arrayOf("A", "C"),
arrayOf("C", "A"),
arrayOf("B", "D"),
)
ICN A B D -> fail
     ICN, SFO, ATL,
ICN   0    1    1
SFO   0    0    1
ATL   1    1    0
("ICN", "SFO"),
("ICN", "ATL"),
("SFO", "ATL"),
("ATL", "ICN"),
("ATL", "SFO")
 */