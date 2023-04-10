package dynamic

import kotlin.math.max

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    val activeAppCost = readln().split(" ").map { it.toInt() }
    val inactiveAppCost = readln().split(" ").map { it.toInt() }

    val appSpec = activeAppCost.mapIndexed { index, currentMemory ->
        currentMemory to inactiveAppCost[index]
    }

    val needMemory = M - appSpec.filter { it.second == 0 }.sumOf { pair ->
        pair.first
    }
    if (needMemory <= 0) {
        println(0)
        return
    }
    val filteredAppSpec = appSpec.filterNot { it.second == 0 }.sortedBy { it.second }
    val costSum = inactiveAppCost.sum()
    val costMap = List(filteredAppSpec.size + 1) {
        IntArray(costSum + 1) { 0 }
    }
    for (i in 1..filteredAppSpec.size) {
        for (j in 0..costSum) {
            if (filteredAppSpec[i - 1].second <= j) {
                costMap[i][j] =
                    max(
                        costMap[i - 1][j],
                        filteredAppSpec[i - 1].first + costMap[i - 1][j - filteredAppSpec[i - 1].second]
                    )
            } else {
                costMap[i][j] = costMap[i - 1][j]
            }
        }
    }
    costMap[filteredAppSpec.size].forEachIndexed { index, i ->
        if (i >= needMemory) {
            println(index)
            return
        }
    }
}