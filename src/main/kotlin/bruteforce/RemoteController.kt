package bruteforce

/*
    백준 1107번 리모컨
    HashSet 이용
    고장난 버튼이 있을 때 채널 100번에서부터 원하는 채널로 이동하려면 몇 번 눌러야하는지
    100번과 가깝다면 그냥 + - 버튼 누르는게 낫다.
    나머지는 완전 탐색, 근데 이거 개빡세게 했네 ㅋㅋㅋ 나도 해석이 안 된다 ㅋㅋ
 */


import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.Math.abs
import java.lang.Math.min

fun main() {
    val N = readln()
    val M = readln().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val hash = HashSet<Int>()
    var answerCount = abs(N.toInt() - 100)

    val array = if (M != 0) {
        readln().split(" ").map { it.toInt() }
    } else {

        if (abs(N.toInt() - 100) <= 3) {
            bw.write(abs(N.toInt() - 100).toString())
            bw.close()
            return@main
        }
        bw.write(N.length.toString())
        bw.close()
        return@main
    }
    if (N == "100") {
        bw.write("0")
        bw.close()
        return@main
    }
    var tempUpperAnswer = ""
    var tempLowerAnswer = ""
    hash.addAll(array)
    var ten = false
    N.forEach {
        val compare = it.digitToInt()
        if (hash.contains(compare)) {
            var i = 1
            while (true) {
                val upper = hash.contains((compare + i) % 10)
                val lower = hash.contains((compare + 10 - i) % 10)
                if (upper && lower) {
                    i++
                } else if (!upper && !lower) {
                    if (compare + i >= 10) {
                        tempUpperAnswer += if (ten) {
                            ((compare + i) % 10)
                        } else {
                            ten = true
                            (compare + i)
                        }
                    } else {
                        tempUpperAnswer += (compare + i)
                        ten = false
                    }
                    if ((compare - i) < 0) {
                        tempLowerAnswer += ("0")
                    } else {
                        tempLowerAnswer += (compare - i)
                    }
                    break
                } else if (lower) {
                    tempLowerAnswer += "0"
                    if (compare + i >= 10) {
                        tempUpperAnswer += if (ten) {
                            ((compare + i) % 10)
                        } else {
                            ten = true
                            (compare + i)
                        }
                    } else {
                        tempUpperAnswer += (compare + i)
                        ten = false
                    }
                    break
                } else {
                    tempLowerAnswer += ("0")
                    tempUpperAnswer += ("9")
                    break
                }
            }
        } else {
            tempLowerAnswer += (it)
            tempUpperAnswer += (it)
        }
    }
    if(tempLowerAnswer.toInt()%10==0&&tempLowerAnswer.toInt()!=0){
        tempLowerAnswer = (tempLowerAnswer.toInt()-1).toString()
    }
    for (i in tempLowerAnswer.toInt()..tempUpperAnswer.toInt()) {
        var contains = true
        i.toString().forEach {
            if (hash.contains(it.digitToInt())) {
                contains = false
                return@forEach
            }
        }
        if (contains) {
            answerCount = min(answerCount, abs(N.toInt() - i) + i.toString().length)
        }
    }

    bw.write(answerCount.toString())
    bw.close()
}


//5555
//3, 7
//4,5, 6
//3, 7
//M = 4, 2^M
//3773 - 5555
