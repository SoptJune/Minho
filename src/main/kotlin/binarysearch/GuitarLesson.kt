package binarysearch

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val array = readln().split(" ").map { it.toInt() }
    var left = 0
    var right =((N * 10_000) / M) + 1

    var min = Int.MAX_VALUE.toDouble()

    if (N == M) {
        println(array.max())
    } else {
        while (left <= right) {
            var sum = 0.0
            var maxItem = 0.0
            val mid = (left + right) / 2
            var count = 1
            array.forEach {
                if (sum + it > mid) {
                    count++
                    maxItem = maxItem.coerceAtLeast(sum)
                    sum = it.toDouble()
                } else {
                    sum += it
                }
            }
            if (count > M) {
                left = mid + 1
            } else {
                min = min.coerceAtMost(maxItem.coerceAtLeast(sum))
                right = mid - 1
            }
        }
        println(min.toInt())
    }
}

/*
강의가 N개 있고 M개의 씨디에 담는다고 할 때 한 씨디당 최대 크기는 몇이 될까?
각 강의의 최대는 10_000분

(10_000 X N) / M 이 최대겠구만~

 */