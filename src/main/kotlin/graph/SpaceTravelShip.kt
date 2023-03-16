package graph

private lateinit var travelMap: List<IntArray>
private var minSum = Int.MAX_VALUE
private lateinit var visitMap: BooleanArray
fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    travelMap = List(N) {
        (readln().split(" ").mapIndexed { index, s ->
            if(index==it) 1_001 else s.toInt()
        }).toIntArray()
    }
    visitMap = BooleanArray(N)
    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                travelMap[i][j] = (travelMap[i][j]).coerceAtMost(travelMap[i][k] + travelMap[k][j])
            }
        }
    }
    travel(K, 0, 1, N)
    println(minSum)
}

private fun travel(currentIndex: Int, sum: Int, count: Int, n: Int) {
    if (count == n) {
        minSum = minSum.coerceAtMost(sum)
        return
    }


    visitMap[currentIndex] = true
    for (i in 0 until n) {
        if (!visitMap[i]) {
            travel(i, sum + travelMap[currentIndex][i], count + 1, n)
        }
    }
    visitMap[currentIndex] = false
}