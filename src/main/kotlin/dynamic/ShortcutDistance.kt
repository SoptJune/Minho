package dynamic

import java.lang.Math.min

/*
    백준 14467번 (지름길)
    DP문제, 이건 말로 설명하기가 어려움
 */
private var N = 0
private var D = 0

private var visit = IntArray(0)
private var array = ArrayList<Triple<Int, Int, Int>>()
fun main() {
    val (tempN, tempD) = readln().split(" ").map { it.toInt() }
    N = tempN
    D = tempD
    if (N == 0) { //지름길 없으면 냅다 종료
        print(D)
        return
    }
    visit = IntArray(D + 1) { it }
    repeat(N) {
        readln().split(" ").map { it.toInt() }.let {
            if (it[1] <= D && it[1] - it[0] > it[2]) //도착지가 D보다 작으면서, 도착 위치 - 시작 위치가 길이보다 클 때만 add
                array.add(Triple(it[0], it[1], it[2]))
        }
    }

    val comparator: Comparator<Triple<Int, Int, Int>> =
        compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenByDescending { it.third }
    //시작 위치순 -> 도착 위치 역순 -> 거리 역순 기준으로 정렬
    array.sortWith(comparator)
    for (i in visit.indices) {
        if (i > 0) visit[i] = min(visit[i], visit[i - 1] + 1)
        array.filter { it.first == i && (visit[i] + it.third) < visit[it.second] }.forEach {//시작 위치이면서, 지름길 썼을 때 이득인 경우의 리스트만 뽑아냄
            visit[it.second] = visit[it.first] + it.third
        }
    }
    print(visit[D])
}