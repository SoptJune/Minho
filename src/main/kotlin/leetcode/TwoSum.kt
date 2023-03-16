package leetcode

fun main() {
    println(twoSum(intArrayOf(3,3), 6).toList())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.size == 2) {
        return nums.mapIndexed { index, i -> index }.toIntArray()
    }
    for (i in nums.indices) {
        val data = nums.indexOf(target - nums[i])
        if (data != -1 && i != data) {
            return intArrayOf(i, data).sortedArray()
        }
    }

    return intArrayOf()
}