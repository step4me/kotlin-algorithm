package twopointer

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */
object ThreeElementSumToZero {
    fun findTriplets(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return emptyList()

        nums.sort()
        val result: MutableList<List<Int>> = mutableListOf()
        val size = nums.size
        for (i in 0..(size - 2)) {
            val firstElement = nums[i]

            // remove duplicate element
            if (i > 0 && firstElement == nums[i-1]) {
                continue
            }

            var leftPointer = i + 1
            var rightPointer = size - 1
            while (leftPointer < rightPointer) {
                val secondElement = nums[leftPointer]
                val thirdElement = nums[rightPointer]
                val sum = firstElement + secondElement + thirdElement
                when {
                    sum < 0 -> {
                        leftPointer++
                    }
                    sum > 0 -> {
                        rightPointer--
                    }
                    else -> {
                        result.add(listOf(firstElement, secondElement, thirdElement))
                        leftPointer++
                        rightPointer--

                        // remove duplicate element -> important: multiple duplicate elements
                        while (leftPointer < rightPointer && secondElement == nums[leftPointer]) {
                            leftPointer++
                        }
                        while (leftPointer < rightPointer && thirdElement == nums[rightPointer]) {
                            rightPointer--
                        }
                    }
                }
            }
        }
        return result
    }
}

fun main() {
    val testInput1 = intArrayOf(-1, 0, 1, 2, -1, -4)
    val testOutput1 = ThreeElementSumToZero.findTriplets(testInput1)
    println("output=${testOutput1}")

    val testInput2 = intArrayOf(-2, 0, 0, 2, 2)
    val testOutput2 = ThreeElementSumToZero.findTriplets(testInput2)
    println("output=${testOutput2}")

    val testInput3 = intArrayOf(-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0)
    // sorted: [-5,-3,-2,-1,0,0,0,1,1,1,3,3,4,4,4]
    val testOutput3 = ThreeElementSumToZero.findTriplets(testInput3)
    println("output=${testOutput3}")
}