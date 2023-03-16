package datastructure


fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var find = 0
    list.forEachIndexed { index, value ->
        var left = 0
        var right = list.size - 1
        while (left < right) {
            val sum = list[left] + list[right]
            if (left == index) left++
            else if (right == index) right--
            else if (sum < value) {
                left++
            } else if (sum == value) {
                find++
                break
            } else {
                right--
            }
        }
    }
    println(find)
}


/*
-10 -5 -4 -3 0 1 2 5 6 8 10


-5 채택
-10 + -4 < -5

 */