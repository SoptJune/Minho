package implement

/*
1초까지 초기값(폭탄 설치)
2초(짝수) 초기 제외 폭탄 설치
3초 초기 터짐
4초 터진거 제외 폭탄 설치
5초 터진 제외 폭탄 터짐
6초 전체 0
7초 나머지 설치 터짐
8초 전체 0
9초 터진 제외 폭탄 터짐(폭탄 설치)
10초 전체 0
*/
var bomberRealMap = ArrayList<CharArray>()

fun main() {

    val (R, C, N) = readln().split(" ").map { it.toInt() }
    repeat(R) {
        bomberRealMap.add(readln().toCharArray())
    }
    if (N == 1) {
        bomberRealMap.forEach { println(it) }
        return
    } else if (N % 2 == 0) {
        Array(R) { CharArray(C) { 'O' } }.forEach {
            println(it)
        }
        return
    }
    var storeBomber = bomberRealMap
    repeat(N) { count ->
        if ((count + 1) > 1) {
            if ((count + 1) % 4 == 3) {
                storeBomber = getPopBombMap(R, C, bomberRealMap) as ArrayList<CharArray>
            } else if ((count + 1) % 4 == 1) {
                bomberRealMap = getPopBombMap(R, C, storeBomber) as ArrayList<CharArray>
            }
        }
    }
    if (N % 4 == 3) {
        storeBomber.forEach {
            println(it)
        }
    } else if (N % 4 == 1) {
        bomberRealMap.forEach { println(it) }
    }
}

fun getPopBombMap(R: Int, C: Int, list: ArrayList<CharArray>): List<CharArray> {
    val tempArray = ArrayList<BooleanArray>()
    val returnArray = List(R) { CharArray(C) { 'O' } }
    list.forEach {
        tempArray.add(it.map { ch -> ch == 'O' }.toBooleanArray())
    }
    for (i in list.indices) {
        repeat(C) { //C 값 길이 만큼
            if (tempArray[i][it]) {
                returnArray[i][it] = '.'
                if (i + 1 in returnArray.indices) returnArray[i + 1][it] = '.'
                if (i - 1 in returnArray.indices) returnArray[i - 1][it] = '.'
                if (it + 1 in returnArray[i].indices) returnArray[i][it + 1] = '.'
                if (it - 1 in returnArray[i].indices) returnArray[i][it - 1] = '.'
            }
        }
    }
    return returnArray
}


/*
반례 입니다.

input 1

6 7 1
OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO



output1

OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO

input2

6 7 2
OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO

output2

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO

input3

6 7 3
OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO

output3

.......
.......
.......
.......
.......
.......

input4

6 7 4
OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO

output4

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO

input5

6 7 5
OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO

output5////

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO

input6

6 7 6
OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO

output6

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO

input7

6 7 7
OOOOOOO
OOOOOOO
OOOOOOO
OOOO.OO
OOOOOOO
OOOOOOO

output7

.......
.......
.......
.......
.......
.......
 */