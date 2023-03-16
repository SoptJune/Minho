package bruteforce

import java.lang.Integer.max
/*
    백준 2468번 안전 영역
    DFS 풀이 2차원 배열 상하좌우 이동
    비가 계속 올 때 안 잠기는 지역의 최대 갯수를 찾는 것
    비의 양이 1 ~ 건물 높이의 max까지 비를 오게 한다.
    그때마다 안전 영역 체크, VisitMap 최신화한다.
    visitMap false이면서 안 잠기는 영역에 대해서 DFS 돌림
 */

private val intRangeX = intArrayOf(0, 0, 1, -1)
private val intRangeY = intArrayOf(1, -1, 0, 0)
private val Num = readln().toInt()
private val arr = ArrayList<List<Int>>()
private var maxCount = 1
private var myMap = Array(Num) { BooleanArray(Num) }
fun main() {
    var maxHeight = 0
    repeat(Num) {
        arr.add(readln().split(" ").map {
            maxHeight = max(it.toInt(), maxHeight)
            it.toInt()
        })
    }
    for (i in 1 until maxHeight) {
        var count = 0
        for (j in 0 until Num) {
            for (k in 0 until Num) {
                if (arr[j][k] - i > 0 && !myMap[j][k]) {
                    myMap[j][k] = true
                    count++
                    search(j, k, i)
                }
            }
        }
        maxCount = max(maxCount, count)
        myMap = Array(Num) { BooleanArray(Num) }
    }
    print(maxCount)
}

private fun search(currentX: Int, currentY: Int, level: Int) {

    for (i in 0 until 4) {
        val dx = currentX + intRangeX[i]
        val dy = currentY + intRangeY[i]
        if (dx < 0 || dy < 0 || dx >= Num || dy >= Num) continue

        if (!myMap[dx][dy] && arr[dx][dy] - level > 0) {
            myMap[dx][dy] = true
            search(dx, dy, level)
        }
    }
}