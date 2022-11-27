package sort

fun main() {
    println(solution(intArrayOf(3, 30, 34, 5, 9)))
}

fun solution(numbers: IntArray): String {
    val comparator = Comparator<String> { o1, o2 ->
        (o2 + o1).compareTo(o1 + o2)
    }
    if(numbers.all { it == 0 }) return "0"
    return numbers.map { it.toString() }.sortedWith(comparator).joinToString("")
}


/* 3 34 4 4954
33 318
3

34
349
343
340

34349
34934

34343
34334

309

342
33


 */