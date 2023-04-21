package graph

import java.util.LinkedList

private val intRangeX = intArrayOf(0, 0, 1, -1)
private val intRangeY = intArrayOf(1, -1, 0, 0)
private var tempMaxCount = 1
private var tempMaxWidth = 0
private var tempMaxHeight = 0
private lateinit var myTable: Array<IntArray>
private lateinit var gameTable: Array<IntArray>
private var maxRow: Int = 0
private var maxRemoveBlock = 0
fun main() {
    println(
        solution(
            arrayOf(
                intArrayOf(1, 1, 0, 0, 1, 0),
                intArrayOf(0, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 0, 1),
                intArrayOf(1, 1, 0, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 1, 1, 0, 0)
            ),
            arrayOf(
                intArrayOf(1, 0, 0, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 1, 1),
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(1, 1, 0, 1, 1, 0),
                intArrayOf(0, 1, 0, 0, 0, 0)
            )
        )
    )

}


/**
 *     퍼즐 남은 공간을 채워 넣어야함,
 *     새로 넣은 블럭은 인접 블럭이 비어있으면 안 된다.
 *     퍼즐 블럭은 회전 가능, 뒤집기는 불가능
 */

data class Puzzle(val y: Int, val x: Int, val maxHeight: Int, val maxWidth: Int)

fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
    var answer: Int = -1
    myTable = table
    maxRow = game_board.size
    gameTable = game_board
    val myTableHashMap = HashMap<Int, MutableSet<Puzzle>>()
    val gameTableHashMap = HashMap<Int, MutableSet<Puzzle>>()
    table.forEachIndexed { y, ints ->
        ints.forEachIndexed { x, i ->
            if (i == 1) {
                myTable[y][x] = 0
                findBlockCount(x, y, 1, 1)
                if (myTableHashMap.containsKey(tempMaxCount)) {
                    myTableHashMap[tempMaxCount]!!.add(Puzzle(y, x, tempMaxHeight, tempMaxWidth))
                } else {
                    myTableHashMap[tempMaxCount] = mutableSetOf(Puzzle(y, x, tempMaxHeight, tempMaxWidth))
                }
            }
            tempMaxCount = 1
            tempMaxHeight = 0
            tempMaxWidth = 0
        }
    }
    game_board.forEachIndexed { y, ints ->
        ints.forEachIndexed { x, i ->
            if (i == 0) {
                gameTable[y][x] = 1
                findBlankCount(x, y, 1, 1)
                if (gameTableHashMap.containsKey(tempMaxCount)) {
                    gameTableHashMap[tempMaxCount]!!.add(Puzzle(y, x, tempMaxHeight, tempMaxWidth))
                } else {
                    gameTableHashMap[tempMaxCount] = mutableSetOf(Puzzle(y, x, tempMaxHeight, tempMaxWidth))
                }
            }
            tempMaxCount = 1
            tempMaxHeight = 0
            tempMaxWidth = 0
        }
    }
    println("#################### MY_GAME_BOARD ####################")
    gameTableHashMap.forEach {
        println(it)
    }
    println()
    println("#################### MY_TABLE ####################")
    myTableHashMap.forEach { map ->
        println(map)
    }

    println()
    println()

    myTableHashMap.forEach { map ->

        if (gameTableHashMap.containsKey(map.key)) {
            if (map.key == 1) {
                val value = gameTableHashMap[map.key]!!.size - map.value.size
                maxRemoveBlock = if (value < 0) {
                    gameTableHashMap[map.key]!!.size
                } else {
                    map.value.size
                }
            } else {
                map.value.forEach {
                    gameTableHashMap[map.key]?.forEach { block ->
                        //TODO

                    }
                }
            }
        }
    }
    return answer
}

fun findBlankCount(x: Int, y: Int, currentWidth: Int, currentHeight: Int) {
    for (i in 0 until 4) {
        val dx = x + intRangeX[i]
        val dy = y + intRangeY[i]
        if (dx < 0 || dy < 0 || dx >= maxRow || dy >= maxRow) continue

        if (gameTable[dy][dx] == 0) {
            gameTable[dy][dx] = 1
            tempMaxCount++
            when (i) {
                0 -> {
                    findBlankCount(dx, dy, currentWidth, currentHeight + 1)
                }

                1 -> {
                    findBlankCount(dx, dy, currentWidth, currentHeight + 1)
                }

                2 -> {
                    findBlankCount(dx, dy, currentWidth + 1, currentHeight)
                }

                3 -> {
                    findBlankCount(dx, dy, currentWidth + 1, currentHeight)
                }
            }
        }
    }
    tempMaxHeight = tempMaxHeight.coerceAtLeast(currentHeight)
    tempMaxWidth = tempMaxWidth.coerceAtLeast(currentWidth)
}

fun findBlockCount(x: Int, y: Int, currentWidth: Int, currentHeight: Int) {
    for (i in 0 until 4) {
        val dx = x + intRangeX[i]
        val dy = y + intRangeY[i]
        if (dx < 0 || dy < 0 || dx >= maxRow || dy >= maxRow) continue
        if (myTable[dy][dx] == 1) {
            myTable[dy][dx] = 0
            tempMaxCount++
            when (i) {
                0 -> {
                    findBlockCount(dx, dy, currentWidth, currentHeight + 1)
                }

                1 -> {
                    findBlockCount(dx, dy, currentWidth, currentHeight + 1)
                }

                2 -> {
                    findBlockCount(dx, dy, currentWidth + 1, currentHeight)
                }

                3 -> {
                    findBlockCount(dx, dy, currentWidth + 1, currentHeight)
                }
            }
        }
    }
    tempMaxHeight = tempMaxHeight.coerceAtLeast(currentHeight)
    tempMaxWidth = tempMaxWidth.coerceAtLeast(currentWidth)
}

fun searchMap(x: Int, y: Int) {

}

/*
    각 블록의 격자 개수를 HashMap으로 만들어둔다. 이걸 어케 만드누,,
        개수랑 시작 위치만 기억해둘까..?
    Game_board를 돌면서 빈 공간이 있으면 격자 개수를 새서 몇개인지 판단(영역을 1로 채우긴 한다.),
    나온 개수를 바탕으로 HashMap에서 하나씩 꺼내서 모양 확인,
    모양에 맞으면 추가한 Count 증가, 안 맞으면 그대로 다음 검색 시작

 */