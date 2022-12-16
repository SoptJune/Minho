package graph

import kotlin.math.min
/*
    프로그래머스 단어 변환
    DFS 풀이, 1차원 배열
    단어 1개만 다른 문자열들을 추출하고, 걔네들로 dfs 서치
 */

private var wordList: Array<String> = arrayOf()
private var targetString = ""
private var wordTour: BooleanArray = booleanArrayOf()
private var maxCount = 0
fun main() {
    //println(("hot".filtering(arrayOf("hot", "dot", "dog", "lot", "log", "cog"))))
    println(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")))
}

private fun String.filtering(list: Array<String>): List<Int> =
    list.mapIndexed { index, item ->
        if (this.minus(item)) {
            index
        } else null
    }.filterNotNull()


private operator fun String.minus(s: String): Boolean =
    this.filterIndexed { index, c ->
        c - s[index] == 0
    }.length == s.length-1


private fun solution(begin: String, target: String, words: Array<String>): Int {
    if (!words.contains(target)) return 0
    wordList = words
    targetString = target
    wordTour = BooleanArray(words.size)
    begin.filtering(wordList).forEach { index ->
        wordTour[index] = true
        dfs(index, 1)
    }
    return maxCount
}

private fun dfs(index: Int, count: Int) {
    if (wordList[index] == targetString) {
        maxCount = if (maxCount == 0) {
            count
        } else {
            min(maxCount, count)
        }
    }
    wordList[index].filtering(wordList).forEach { filterIndex ->
        if (!wordTour[filterIndex]) {
            wordTour[filterIndex] = true
            dfs(filterIndex, count + 1)
            wordTour[filterIndex] = false
        }
    }
}


/*
hit

cog

hot dot dog lot log cog
010 010 011 010 011 111
hit
101 001 000 001 000 000
hot
111 011 010 011 010 010
dot, lot
tru tru 110 011 010 010
tru 011 010 tru 110 010
dog, log, dot, lot
tru tru tru tru 011 011

 */