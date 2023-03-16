package implement


private val intRangeX = intArrayOf(1, 0, -1, 0)
private val intRangeY = intArrayOf(0, 1, 0, -1)

fun main() {
    val (M, N) = readln().split(" ").map { it.toInt() }
    val visitMap = Array(M) {
        BooleanArray(N)
    }
    var index = 0
    var x = 0
    var y = 0
    var count = 0
    for (i in 0 until N * M) {
        if (x >= N && index == 0) {
            index++
            println("Find Index 1")

            x = N - 1
            visitMap[y][x] = false
            count++
        } else if (y >= M && index == 1) {
            index++
            println("Find Index 2")
            y = M - 1
            count++
            visitMap[y][x] = false
        } else if (x < 0 && index == 2) {
            index++
            println("Find Index 3")
            x = 0
            count++
            visitMap[y][x] = false
        } else if (y < 0 && index == 3) {
            index = 0
            y = 0
            println("Find Index 4")
            count++
            visitMap[y][x] = false
        }
        if (!visitMap[y][x]) {
            visitMap[y][x] = true
            x += intRangeX[index]
            y += intRangeY[index]
        } else {
            x -= intRangeX[index]
            y -= intRangeY[index]
            visitMap[y][x] = false
            println("Index $index")
            index = (index + 1) / 4
        }
    }
    println(count)
}