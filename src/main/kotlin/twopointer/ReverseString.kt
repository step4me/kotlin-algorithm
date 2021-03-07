package twopointer

/**
 * 344. Reverse String
 * @see [https://leetcode.com/problems/reverse-string/]
 */
object ReverseString {
    // Do not allocate extra space for another array,
    // you must do this by modifying the input array in-place with O(1) extra memory.
    fun reverseString(s: CharArray): Unit {
        if (s.isEmpty()) return
        var leftPointer = 0
        var rightPointer = s.lastIndex
        while (leftPointer < rightPointer) {
            val temp = s[leftPointer]
            s[leftPointer++] = s[rightPointer]
            s[rightPointer--] = temp
        }
        print("output: ${s.joinToString(",")}")
    }
}

fun main(args: Array<String>) {
    val input = charArrayOf('h', 'e', 'l', 'l', 'o')
    ReverseString.reverseString(input)
}