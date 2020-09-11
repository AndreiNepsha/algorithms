package nepsha.codewars

import kotlin.math.ceil
import kotlin.math.floor

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

    inline fun calculateIntegerSum(lastNumber: Long): Long = ((lastNumber+1)*lastNumber)/2

    fun calculateSequenceDigits(numbers: Long): Long {
        var reminder = numbers
        var digits = 0L
        var fullyCalculated = 9L

        while (reminder > 0) {
            digits += calculateIntegerSum(reminder)
            reminder -= fullyCalculated
            fullyCalculated *= 10
        }

        return digits
    }

    fun solve(n: Long): Int {
        var i = 1L
        var sequenceDigits = 1L
        var k = 2.0
        while (sequenceDigits in 1 until n) {
            k = if (k <= 1.2) 1.2 else k - 0.1
            i = kotlin.math.ceil(i * k).toLong()
            sequenceDigits = calculateSequenceDigits(i)
        }
        i = kotlin.math.floor(i / k).toLong()
        while (calculateSequenceDigits(i) < n) i++

        val indInLastSeq = n - calculateSequenceDigits(i-1)
        return getNthSubSequenceDigit(indInLastSeq)
    }

//    fun getLastSubSequenceStart(n: Long) {
//        var lastNumber = 9
//        var lastNumberDigits = 1
//        var digitsInSeqWithCurNumberLength = 45
//        var totalDigits = digitsInSeqWithCurNumberLength
//
//        while (totalDigits < n) {
//            lastNumber = (lastNumber * 10) + 9
//            lastNumberDigits++
//            digitsInSeqWithCurNumberLength = ((((lastNumber+1) * lastNumber) / 2) * lastNumberDigits) - digitsInSeqWithCurNumberLength
//            totalDigits += digitsInSeqWithCurNumberLength
//        }
//
//        totalDigits -= digitsInSeqWithCurNumberLength
//    }
//
//    fun ttt(startSeqLen: Long, n: Long) {
//        var curSeqLen = 1L
//        var curSeqDigits = 1L
//        var curSeqMaxNumberDigits = 1L
//        var curSeqMaxNumberCeil = 10L
//        var totalDigits = 1L
//
//        while (totalDigits < n) {
//            curSeqLen++
//            if (curSeqLen >= curSeqMaxNumberCeil) {
//                curSeqMaxNumberCeil *= 10
//                curSeqMaxNumberDigits++
//            }
//            curSeqDigits += curSeqMaxNumberDigits
//
//            totalDigits += curSeqDigits
//        }
//
//        val indInLastSeq = n - (totalDigits - curSeqDigits)
//    }
//
//    fun solve(n: Long): Int {
//        var curSeqLen = 1L
//        var curSeqDigits = 1L
//        var curSeqMaxNumberDigits = 1L
//        var curSeqMaxNumberCeil = 10L
//        var totalDigits = 1L
//
//        while (totalDigits < n) {
//            curSeqLen++
//            if (curSeqLen >= curSeqMaxNumberCeil) {
//                curSeqMaxNumberCeil *= 10
//                curSeqMaxNumberDigits++
//            }
//            curSeqDigits += curSeqMaxNumberDigits
//
//            totalDigits += curSeqDigits
//        }
//
//        val indInLastSeq = n - (totalDigits - curSeqDigits)
//        return getNthSubSequenceDigit(indInLastSeq)
//    }
}

