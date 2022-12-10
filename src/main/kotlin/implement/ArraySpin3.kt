package implement

fun main() {
    val (N, M, R) = readln().split(" ").map { it.toInt() }
    var array = List(N) { mutableListOf<Int>() }
    repeat(N) {
        array[it].addAll(readln().split(" ").map { it.toInt() })
    }
    readln().split(" ").map { it.toInt() }.forEach {
        when (it) {
            1 -> {
                array = operation1(array)
            }
            2 -> {
                array = operation2(array)
            }
            3 -> {
                array = operation3(array)
            }
            4 -> {
                array = operation4(array)
            }
            5 -> {
                operation5(array)
            }
            6 -> {
                operation6(array)
            }
        }
    }
    array.forEach {
        println(it.joinToString(" "))
    }
}

fun operation1(array: List<MutableList<Int>>): List<MutableList<Int>> {
    return array.reversed()
}

fun operation2(array: List<MutableList<Int>>): List<MutableList<Int>> {
    return array.map { it.asReversed() }
}

fun operation3(array: List<MutableList<Int>>): List<MutableList<Int>> {
    val tempArray = List<MutableList<Int>>(array[0].size) { mutableListOf() }

    for (i in array[0].indices) {
        tempArray[i].addAll(array.map { it[i] }.asReversed())
    }
    return tempArray
}

fun operation4(array: List<MutableList<Int>>): List<MutableList<Int>> {
    val tempArray = List<MutableList<Int>>(array[0].size) { mutableListOf() }

    for (i in array[0].indices) {
        tempArray[i].addAll(array.map { it[it.size - (i + 1)] })
    }
    return tempArray
}

fun operation5(array: List<MutableList<Int>>) {
    changeLeftToRight(array, array.size / 2, 0)
    changeTopToBottom(array, array[0].size / 2, 0)
    changeLeftToRight(array, array.size / 2, array.size / 2)
}

fun operation6(array: List<MutableList<Int>>) {
    changeLeftToRight(array, array.size / 2, 0)
    changeTopToBottom(array, array[0].size / 2, array[0].size / 2)
    changeLeftToRight(array, array.size / 2, array.size / 2)
}

fun changeLeftToRight(array: List<MutableList<Int>>, height: Int, startIndex: Int) {
    val widthSize = array[0].size / 2
    repeat(height) {
        for (i in 0 until widthSize) {
            val temp = array[startIndex + it][i]
            array[startIndex + it][i] = array[startIndex + it][widthSize + i]
            array[startIndex + it][widthSize + i] = temp
        }
    }
}

fun changeTopToBottom(array: List<MutableList<Int>>, width: Int, startIndex: Int) {
    val heightSize = array.size / 2
    repeat(heightSize) {
        for (i in startIndex until startIndex + width) {
            val temp = array[it][i]
            array[it][i] = array[heightSize + it][i]
            array[heightSize + it][i] = temp
        }
    }
}
/*
1 2 3 4
1 2 3 4
1 2 3 4
1 2 3 4
 */