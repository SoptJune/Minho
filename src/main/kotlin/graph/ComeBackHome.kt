package graph

private val intRangeX = intArrayOf(0, 0, 1, -1)
private val intRangeY = intArrayOf(1, -1, 0, 0)
private lateinit var map: Array<BooleanArray>
private lateinit var comeback: Array<CharArray>
private var countNum = 0
fun main() {
    val (R, C, K) = readln().split(" ").map { it.toInt() }
    map = Array(R) {
        BooleanArray(C)
    }
    comeback = Array(R) {
        CharArray(C)
    }
    repeat(R) {
        comeback[it] = readln().toCharArray()
    }
    map[R - 1][0] = true
    dfss(0, R - 1, 1, K)
    println(countNum)
}

fun dfss(currentX: Int, currentY: Int, count: Int, targetNum: Int) {
    if (currentX == map[0].size - 1 && currentY == 0 || targetNum < count) {
        if (targetNum == count) {
            countNum++
        }
    } else {
        for (i in 0 until 4) {
            val dx = currentX + intRangeX[i]
            val dy = currentY + intRangeY[i]
            if (dx < 0 || dy < 0 || dx >= map[0].size || dy >= map.size || comeback[dy][dx] == 'T') continue
            if (!map[dy][dx]) {
                map[dy][dx] = true
                dfss(dx, dy, count + 1, targetNum)
                map[dy][dx] = false
            }
        }
    }
}