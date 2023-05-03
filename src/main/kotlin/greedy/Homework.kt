package greedy

fun main() {
    val N = readln().toInt()
    val result = IntArray(1001)
    val array = List(N) {
        readln().split(" ").map { it.toInt() }.run {
            this[0] to this[1]
        }
    }.sortedByDescending { it.second }
    for (i in 0 until N) {
        for (j in array[i].first downTo 1) {
            if (result[j] == 0) {
                result[j] = array[i].second
                break
            }
        }
    }
    println(result.sum())
}


/*
        6   4   1   3   4   2   4
(가치순)  5, 10, 20, 30, 40, 50, 60


(기간순)  20, 50, 30, 60, 40, 10, 5

(기간순을 날짜로 나눈 케이스)
20, 25, 10, 15, 10, 2.5, 0.8333


    어떤 기준으로 더 뒷 날을 고르게 할 것인가?
    거스름돈 거슬러주는 느낌으로 해야하나?

    1일 있다 기준
    60

    2일 기준
    50 + 60 = 110

    3일 기준
    50 + 60 + 40 = 150

    4일 기준
    50 + 30 + 40 + 60 = 180

    5일 기준
    50 + 30 + 40 + 60 + 5 = 185

    6일 기준
    50 + 30 + 40 + 60 + 5 = 185

 */