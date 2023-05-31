package string

fun main() {
    val n = readln().toInt()
    val array = Array(n) {
        readln().split(" ").map { (it.toList()) }
    }

    array.forEachIndexed { index, words ->
        val map = Array(words[0].size + 1) {
            BooleanArray(words[1].size + 1)
        }
        map[0][0] = true
        for (i in 1..words[0].size) map[i][0] = if (words[0][i - 1] == words[2][i - 1]) map[i - 1][0] else false
        for (i in 1..words[1].size) map[0][i] = if (words[1][i - 1] == words[2][i - 1]) map[0][i - 1] else false

        for (i in 1..words[0].size) {
            for (j in 1..words[1].size) {
                val left = words[0][i - 1]
                val right = words[1][j - 1]
                val findValue = words[2][i + j - 1]
                if (left != findValue && right != findValue)
                    map[i][j] = false
                else if (left == findValue && right != findValue)
                    map[i][j] = map[i - 1][j]
                else if (left != findValue)
                    map[i][j] = map[i][j - 1]
                else map[i][j] = map[i - 1][j] || map[i][j - 1]
            }
        }
        println("Data set ${index + 1}: ${if (map[words[0].size][words[1].size]) "yes" else "no"}")
    }
}

/*

cat ccat

catccat

 */