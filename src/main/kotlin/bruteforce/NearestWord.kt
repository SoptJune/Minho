package bruteforce
/*
    프로그래머스 가장 가까운 글자
    뭐 없음
 */

fun main() {
    search("foobar")
}

private fun search(s: String): IntArray {
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