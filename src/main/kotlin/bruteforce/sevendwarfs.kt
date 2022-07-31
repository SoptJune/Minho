package bruteforce
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val data = ArrayList<Int>()
    for (i in 1..9) {
        data.add(readLine().toInt())
    }
    data.sort()
    val findValue = data.sum() - 100
    for (i in 0..8) {
        for (j in i + 1..8) {
            if (data[i] + data[j] == findValue) {
                for (p in 0..8) {
                    if (p != i && p != j) {
                        println(data[p])
                    }
                }
                return@with
            }
        }
    }
}
