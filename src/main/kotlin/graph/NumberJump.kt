package graph

/*
    백준 2210번 (숫자판 점프)
    visit map 없이 그냥 다 보내는 것이다.
 */


private val intRangeX = intArrayOf(0, 0, 1, -1)
private val intRangeY = intArrayOf(1, -1, 0, 0)
private val ans = mutableSetOf<String>()
private val map = ArrayList<List<String>>()

fun main() {
    repeat(5) {
        map.add(readln().split(" "))
    }

    repeat(5) { y ->
        repeat(5) { x ->
            searchSixDigits(1, map[y][x], Pair(y, x))
        }
    }
    print(ans.size)
}

private fun searchSixDigits(count: Int, str: String, point: Pair<Int, Int>) {
    if (count == 6) {
        ans.add(str)
        return
    }

    for (i in 0 until 4) {
        val dx = point.second + intRangeX[i]
        val dy = point.first + intRangeY[i]
        if (dx < 0 || dy < 0 || dx >= 5 || dy >= 5) continue
        searchSixDigits(count + 1, str + map[dy][dx], Pair(dy, dx))
    }
}