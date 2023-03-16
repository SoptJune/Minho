package dynamic


data class City(val cost: Int, val count: Int)

fun main() {
    val (C, N) = readln().split(" ").map { it.toInt() }
    val costMap = ArrayList<City>()
    repeat(N) {
        costMap.add(readln().split(" ").map { value -> value.toInt() }.run {
            City(this[0], this[1])
        })
    }
    val DP = Array<Int>(C * 101) {
        0
    }

    if (C == 1) {
        println(costMap.minBy { it.cost }.cost)
        return
    }

    if (costMap.all { it.count >= C }) {
        println(costMap.minBy { it.cost }.cost)
        return
    }

    for (i in 0 until N) {
        for (j in costMap[i].cost until C * 101) {
            DP[j] = maxOf(DP[j], DP[j - costMap[i].cost] + costMap[i].count)
        }
    }

    for (i in 1 until C * 101) {
        if (DP[i] >= C) {
            println(i)
            return
        }
    }
}


/*

Cost구하는건 제일 좋은 녀석의 배수가 제일 최고일것임.
Modular 연산에서 !=0 인 경우에
하나 더 더할지 나머지들의 rest에 대한 cost 계산한 것중에 뭐가 더 나은지 계산 해야함

    if (C == 1) {
        println(costMap.minBy { it[0] })
        return
    }
    if (N == 1) {
        val cost = costMap.first()
        if (C % cost[1] == 0) {
            println((C / cost[1]) * cost[0])

        } else {
            println((C / cost[1]) * (cost[0] + 1))
        }
        return
    }
    if (costMap.all { it[1] > C }) {
        println(costMap.minBy { it[0] })
        return
    }

val maxArray = costMap.maxBy { it[1].toDouble() / it[0].toDouble() }
costMap.sortBy { it[1] }
val rest = (C % maxArray[1])
costMap.forEach {
    println(it.toList())
}
val costValue = (C / maxArray[1]) * maxArray[0]
if (rest == 0) {
    println(costValue)
    return
}
    if (rest == 0) {
        println(costValue)
        return
    } else {
        val maxSecondArray = costMap.maxBy { it[1].toDouble() / it[0].toDouble() }
        val restCost = mutableListOf<Pair<Int, Int>>()

        for (restArray in costMap) {
            if (rest % restArray[1] == 0) {
                restCost.add((rest / restArray[1]) * restArray[0] to restArray[0])
            } else {
                restCost.add((rest / restArray[1]) * (restArray[0] + 1) to restArray[0])
            }
        }
        restCost.minBy { it.first }

    }
    println(rest)
    println(costValue)
1100

C = 100
1 2
3 2

이떄부터 망한 케이스
C = 50
30 100
20 50
1 9
3 5
2 10
3 29

500

0 1 2 3 4 5   6   7    8  9
1 2 4 6 8 10  12  14  16  18
3 0 3 3 6 6   9   9    12
-     2 4 6   4   6   8   6
6
 */