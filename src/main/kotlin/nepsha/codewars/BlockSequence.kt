package nepsha.codewars

// correct but not efficient solution
object BlockSequence {
    fun getNthSubSequenceDigit(n: Long): Int {
        var totalDigits = 0L
        var currentNumber = 1L
        var currentNumberCeil = 10L
        var currentNumberDigits = 1
        while (totalDigits + currentNumberDigits < n) {
            totalDigits += currentNumberDigits
            currentNumber++
            if (currentNumber == currentNumberCeil) {
                currentNumberCeil *= 10
                currentNumberDigits++
            }
        }
        totalDigits += currentNumberDigits
        val indexInLastNumber = (n - (totalDigits - currentNumberDigits)).toInt() - 1

        return currentNumber.toString()[indexInLastNumber].toString().toInt()
    }

    fun solve(n: Long): Int {
        var curSeqLen = 1L
        var curSeqDigits = 1L
        var curSeqMaxNumberDigits = 1L
        var curSeqMaxNumberCeil = 10L
        var totalDigits = 1L

        while (totalDigits < n) {
            curSeqLen++
            if (curSeqLen >= curSeqMaxNumberCeil) {
                curSeqMaxNumberCeil *= 10
                curSeqMaxNumberDigits++
            }
            curSeqDigits += curSeqMaxNumberDigits

            totalDigits += curSeqDigits
        }

        val indInLastSeq = n - (totalDigits - curSeqDigits)
        return getNthSubSequenceDigit(indInLastSeq)
    }
}

