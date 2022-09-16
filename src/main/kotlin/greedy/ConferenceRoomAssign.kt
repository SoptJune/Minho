package greedy

fun main() {
    val n = readln().toInt()
    val array = ArrayList<Pair<Int, Int>>()
    repeat(n) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        array.add(Pair(start, end))
    }
    val comparator: Comparator<Pair<Int, Int>> = compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first }
    array.sortWith(comparator)
    var temp = array[0].second
    var cnt = 1
    for (i in 1..array.lastIndex) {
        if (temp <= array[i].first || array[i].first == array[i].second) {
            cnt++
            temp = array[i].second
        }
    }
    println(cnt)
}