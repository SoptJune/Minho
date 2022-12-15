package bruteforce

fun main() {
    search("foobar")
}

fun search(s: String): IntArray {
    val answer = IntArray(s.length)
    val map = mutableSetOf<Pair<Char, Int>>()
    s.forEachIndexed { index, c ->
        val item = map.find { it.first == c }
        answer[index] = if (item != null) {
            map.remove(item)
            map.add(c to index)
            index - item.second
        } else {
            map.add(c to index)
            -1
        }
    }
    println(answer.toList())
    return answer
}