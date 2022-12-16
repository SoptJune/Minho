package bruteforce

/*
    이거 못 품,,
 */

fun main() {
    println(solution(arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"), arrayOf("*rodo", "*rodo", "******")))
}

private fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
    var answer = 1

    var badUserMap: Map<String, List<String>>

    badUserMap = banned_id.groupBy { it }
    var find = true
    var count = 0

    var mapIndex = 0

    var visitMap = BooleanArray(badUserMap.size)
    badUserMap.forEach { map ->

        user_id.forEachIndexed { index, s ->
            if (!visitMap[mapIndex]) {
                if (map.key.length == s.length) {
                    find = true
                    if (!map.key.all { ch -> ch == '*' }) {
                        for (i in s.indices) {
                            if (map.key[i] != s[i] && map.key[i] != '*') {
                                find = false
                                break
                            }
                        }
                    }
                    if (find) {
                        visitMap[index] = true
                        println(s)
                        count++
                    }
                }
            }
        }
        if (count != 0) answer *= count
        mapIndex++
    }


    println(badUserMap)
    return answer
}