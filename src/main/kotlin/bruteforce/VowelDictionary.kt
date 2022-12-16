package bruteforce

private enum class Number(val select: Int) {
    A(0), E(1), I(2), O(3), U(4)
}
fun main() {
    solution("AAAAE")
}
private val distance = listOf(5, 25, 125, 625, 3125)

private fun solution(word: String): Int = when (word.length) {
    1 -> {
        if (word == "A") 1
        else Number.valueOf(word).select * 781 + 1
    }
    else -> {
        word.mapIndexed { index, c ->
            if (c == 'A') 1
            else 3905 / distance[index] * Number.valueOf(c.toString()).select + 1
        }.sum()
    }
}
/*
A
AA
AAA
AAAA

A E I O U
1 2 3 4 5
0  5, 25, 125, 625, 3125
3905 하나씩 올릴 때
1, 6, 31, 156, 781
자리수 올라갈 때

AAAAA   5
AAAAE   6
AAAAI   7
AAAAO   8
AAAAU   9
AAAE   10

AAAEA  11
AAAEE  12
AAAEI  13
AAAEO  14
AAAEU  15
AAAI   16

AAAIA  17
AAAIE  18
AAAII  19
AAAIO  20
AAAIU  21
AAAO   22

AAAOA  23
AAAOE  24
AAAOI  25
AAAOO  26
AAAOU  27
AAAU   28

AAAUA  29
AAAUE  30
AAAUI  31
AAAUO  32
AAAUU  33

AAE    34
AAEA   35
AAEAA  36
*/
