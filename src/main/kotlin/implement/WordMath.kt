package implement

import kotlin.math.pow


/*
  GCF
ACDEB

Loop 1
A = 9
Loop 2
C = 8
Loop 3
D = 7, G = 6
Loop 4
E = 5
Loop 5
F = 4
B = 3
98753
  684
  이게 아니라니
 */
private lateinit var map: HashMap<Char, Int>
fun main() {
    val N = readln().toInt()
    val array = Array(N) {
        CharArray(10)
    }
    repeat(N) {
        array[it] = readln().toCharArray()
    }
    val maxLength = array.maxOf { it.size }
    val reversedArray = array.map {
        it.reversed()                                //뒤집어서부터 계산한당
    }
    var digit = 10.0.pow(maxLength - 1).toInt()   //제일 큰 수 부터 넣을래~
    val weightMap = HashMap<Char, Int>()
    for (i in (maxLength - 1) downTo 0) {
        for (j in 0 until N) {
            if (reversedArray[j].size - 1 < i) continue  //자리수 안 맞으면 점프
            weightMap[reversedArray[j][i]] = (weightMap[reversedArray[j][i]] ?: 0) + digit  //자릿수에 따른 weight를 만들어준다.
        }
        digit /= 10
    }
    var value = 9
    println(weightMap.entries.sortedByDescending { it.value }.sumOf {
        it.value * value--              //weight만큼에서 정할 숫자만큼 곱한다.
    })

    /*println(array.sumOf {
        convertWordToNumber(it)
    })*/
    /*array.sortByDescending { it.size }
    val maxLength = array.first().size
    val reversedArray = array.map {
        it.reversed()
    }
    map = HashMap()
    var value = 9
    for (i in (maxLength - 1) downTo 0) { 기존에는 자리수에 따라서 숫자를 부여해주었음
        for (j in 0 until N) {
            if (reversedArray[j].size - 1 < i) continue
            if (!map.containsKey(reversedArray[j][i])) {
                map[reversedArray[j][i]] = value--
            }
        }
    }
    println(array.sumOf {
        convertWordToNumber(it).apply {
            println(this)
        }
    })*/
}

private fun convertWordToNumber(charArray: CharArray): Int {
    var digit = 10.0.pow(charArray.size)
    return charArray.sumOf {
        digit /= 10
        digit * map[it]!!
    }.toInt()
}
