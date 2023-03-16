package implement

import java.util.regex.Pattern
import kotlin.math.abs

fun main() {
    //solution2(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right")
    //println(solution2(626331))
    //println(solution4(3))
    //println(solution5(" 3a   a4   ff2   aa1   ss4 "))
    println(solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)))
}

fun solution(topping: IntArray): Int {

    if (topping.size == 1) {
        return 0
    }
    val me = mutableSetOf<Int>()
    val brother = topping.toMutableSet()
    var count = 0
    val toppingMap = Array<Int>((topping.maxOrNull() ?: 0) + 5) { 0 }
    topping.forEach {
        toppingMap[it]++
    }
    topping.forEach {
        me.add(it)
        toppingMap[it]--
        if (toppingMap[it] <= 0) {
            brother.remove(it)
        }
        if (brother.size == me.size) {
            count++
        } else if (brother.size < me.size) {
            return@forEach
        }
    }
    return count
}

fun solution5(s: String): String {
    val pattern = Pattern.compile("\\s{2,}")
    val filtered = pattern.matcher(s.trim()).replaceAll(" ")
    val str = filtered.split(" ").map {
        it.trim().lowercase().toCharArray().run {
            this[0] = this[0].uppercaseChar()
            this.concatToString()
        }
    }
    return str.joinToString(" ")
}

fun solution4(n: Int): String {
    val str = StringBuilder()
    repeat(n) {
        if (it % 2 == 0) str.append("수") else str.append("박")
    }
    return str.toString()
}

fun solution3(num: Int): Int {
    var count = 0
    var numVariable = num
    while (numVariable != 1) {
        if (count == 500) {
            return -1
        }
        if (numVariable < 0) {
            return -1
        }
        if (numVariable % 2 == 0) {
            numVariable /= 2
        } else {
            numVariable *= 3
            numVariable++
        }
        count++
    }
    return count
}

fun solution2(numbers: IntArray, hand: String): String {
    var left = Pair(4, 1)
    var right = Pair(4, 3)

    numbers.forEach {

        val left_Y = if (it == 0) 4 else abs(left.first - ((it / 3) + 1))
        val left_X = if (it == 0) 2 else if (it % 3 == 0) 3 else abs(left.second - it % 3)
        val right_Y = if (it == 0) 4 else abs(right.first - ((it / 3) + 1))
        val right_X = if (it == 0) 2 else if (it % 3 == 0) 3 else abs(right.second - it % 3)
        if (left_Y + left_X < right_X + right_Y) {
            left = Pair(left_Y, left_X)
            print("L $left")
        } else if (left_Y + left_X > right_X + right_Y) {
            print("R $right")
            right = Pair(right_Y, right_X)
        } else {
            when (hand) {
                "left" -> {
                    left = Pair(left_Y, left_X)
                    print("L $left")
                }
                "right" -> {
                    right = Pair(right_Y, right_X)
                    print("R $right")
                }
            }
        }
    }
    return ""

}