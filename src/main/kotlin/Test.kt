
/*
구현 2  dfs bfs 1 문자열1 greedy1
다이젝스트라랑 DP도 풀면 좋음, 구현 문제 많이 나옴

시간복잡도 계산하면 유형 나옴

N>10만정도로 넘어가면 이분탐색, 다이젝스트라, 정렬, 크루스칼 중 하나
다이젝스트라는 pq로, pq에 Comparator 잘 넣어라

누적합도 가끔 나옴

문자열, Random, Graph 나올 것 같음

문자열은 KMP까지는 절대 안 나올듯

중복 허용 관련 꼭 체크하기

머리로 안 풀리는건 완전 탐색
n범위 1000 이하면 그냥 완전 탐색, 100이하는 n^3도 괜춘
n범위 15이하는 순열 조합, 백트래킹이라 완전탐색

union find, [0,1,-1,0], 백트래킹, dfs, bfs도 기본 틀 요런건 만들어두기

 */
class Test {

    private val intRangeX = intArrayOf(0, 0, 1, -1)
    private val intRangeY = intArrayOf(1, -1, 0, 0)

    private fun DFSSearch(currentX: Int, currentY: Int, level: Int) {

        for (i in 0 until 4) {
            val dx = currentX + intRangeX[i]
            val dy = currentY + intRangeY[i]
            if (dx < 0 || dy < 0 || dx >= 5 || dy >= 5) continue //영역 침범했는지

            if (false) { // 특정 경우에만 이동하게
                DFSSearch(dx, dy, level)
            }
        }
    }
}
