package nepsha.codewars

object MaximumSubarraySum {
    fun maxSequence(arr: List<Int>): Int {
        var maxSum = 0
        var curSum = 0

        arr.forEach {
            curSum += it

            if (curSum < 0) curSum = 0
            if (curSum > maxSum) maxSum = curSum
        }

        return maxSum
    }
}

