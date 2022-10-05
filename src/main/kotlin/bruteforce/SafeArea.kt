package bruteforce

import java.lang.Integer.max


val intRangeX = intArrayOf(0, 0, 1, -1)
val intRangeY = intArrayOf(1, -1, 0, 0)
val Num = readln().toInt()
val arr = ArrayList<List<Int>>()
var maxCount = 1
var myMap = Array(Num) { BooleanArray(Num) }
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

fun search(currentX: Int, currentY: Int, level: Int) {

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