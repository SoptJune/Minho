package graph



/*
6
9
1 2 5
1 1 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8

 */
fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    val networkTempArray = ArrayList<Triple<Int, Int, Int>>()
    repeat(M) {
        networkTempArray.add(readln().split(" ").map { it.toInt() }.run {
            if (this[0] < this[1])
                Triple(this[0], this[1], this[2])
            else Triple(this[1], this[0], this[2])
        })
    }
    val networkArray = networkTempArray.filter { it.first != it.second }.sortedBy { it.third }

    val unionMap = IntArray(N + 1) { it }
    var answer = 0
    networkArray.forEach {triple->
        if(unionNode(unionMap, triple.first, triple.second)){
            answer += triple.third
        }
    }
    println(answer)
}

private fun getParent(nodes: IntArray, value: Int): Int =
    if (nodes[value] == value) {
        value
    } else {
        nodes[value] = getParent(nodes, nodes[value])
        nodes[value]
    }

private fun unionNode(nodes: IntArray, first: Int, second: Int): Boolean {
    val firstValue = getParent(nodes, first)
    val secondValue = getParent(nodes, second)
    if (firstValue == secondValue) return false
    if (firstValue > secondValue)
        nodes[firstValue] = secondValue
    else
        nodes[secondValue] = firstValue
    return true
}