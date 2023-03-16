package bruteforce

/*
    프로그래머스 보석 쇼핑
    투포인트 알고리즘 풀이
    해시맵 썼음, Set 썼음
    모든 보석 종류를 살 때 최소 구간 출력
    start=0이고 모든 종류 채워졌을 때, start를 늘려가며 해당 보석을 빼봄
    일치 하지 않은 순간까지 뺀다. 일치 하지 않으면 해당 구간 저장
    start를 end로 최신화, 나머지 부분 계산
 */

fun main() {
    println(
        solution(
            arrayOf(
                "ZZZ", "YYY", "NNNN", "YYY", "BBB"
            )
        ).toList()
    )
}

private fun solution(gems: Array<String>): IntArray {
    val answer = gems.toSet()
    val transform = HashMap<String, Int>()

    var start = 0
    if (answer.size == 1) {
        return intArrayOf(1, 1)
    } else if (answer.size == gems.size) {
        return intArrayOf(1, gems.size)
    }
    var short = Triple(Int.MAX_VALUE, 1, gems.size)
    gems.forEachIndexed { index, gem ->
        transform[gem] = transform[gem]?.plus(1) ?: 1
        if (transform.size == answer.size) {
            var findIndex = start
            while (true) {
                if (transform.size != answer.size) {
                    if (short.third > (index + 1) - findIndex) {
                        short = Triple(findIndex, index + 1, (index + 1) - findIndex)
                    }
                    break
                } else {
                    if (transform[gems[findIndex]] == 1) {
                        transform.remove(gems[findIndex])
                    } else {
                        transform[gems[findIndex]] = transform[gems[findIndex]]?.minus(1) ?: 1
                    }
                }
                findIndex++
            }
            start = findIndex
        }
    }
    return intArrayOf(short.first, short.second)
}
/*
1 1 1 1 1 2 2 3 1 2 3


 */