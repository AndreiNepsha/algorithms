package nepsha.codewars

import org.junit.Test
import kotlin.test.assertEquals

object KataSolution {
    fun getSubSequenceDigitCount(sequenceLength: Long): Long {
        val maxDigitCount = sequenceLength.toString().length
        val firstMaxDigitNumber = (1 until maxDigitCount).fold(1L, { acc, _ -> acc * 10})
        var digitCountTotal = (sequenceLength - firstMaxDigitNumber + 1) * maxDigitCount

        var rem = firstMaxDigitNumber
        var digits = 1
        var numCount = 9
        while (rem > 1) {
            digitCountTotal += digits * numCount
            numCount *= 10
            digits++
            rem /= 10
        }

        return digitCountTotal
    }

    fun getNthSubSequenceDigit(n: Long): Int {
        var ind = 1L
        var k = 1L
        var kCeil = 10L
        var kDigitCount = 1
        while (ind < n) {
            ind += kDigitCount
            k++
            if (k == kCeil) {
                kCeil *= 10
                kDigitCount++
            }
        }

        if (ind > n) k--

        return k.toString()[(ind-n).toInt()].toString().toInt()
    }

    fun solve(n: Long): Int {
        var curSeqLen = 1L
        var curSeqDigitLen = 1L
        var curSeqMaxNumDigitCount = 1L
        var curSeqMaxNumCeil = 10L
        var totalSeqDigitLength = 1L

        while (totalSeqDigitLength < n) {
            curSeqLen++
            if (curSeqLen >= curSeqMaxNumCeil) {
                curSeqMaxNumCeil *= 10
                curSeqMaxNumDigitCount++
            }
            curSeqDigitLen += curSeqMaxNumDigitCount

            totalSeqDigitLength += curSeqDigitLen
        }

        val indInLastSeq = n - (totalSeqDigitLength - curSeqDigitLen)
        return getNthSubSequenceDigit(indInLastSeq)
    }
}


class Test {
    private fun runTest(n:Long,sol:Int) = assertEquals(sol,KataSolution.solve(n))

    @Test
    fun `Basic Test Cases`() {
//        runTest(1L,1)
//        runTest(2L,1)
//        runTest(3L,2)
//        runTest(100L,1)
//        runTest(2100L,2)
//        runTest(31000L,2)
        runTest(999999999999999999L,4)
        runTest(1000000000000000000L,1)
        runTest(999999999999999993L,7)
    }

    @Test
    fun `getNthSubSequenceDigit`() {
        assertEquals(5, KataSolution.getNthSubSequenceDigit(5))
        assertEquals(9, KataSolution.getNthSubSequenceDigit(9))
        assertEquals(1, KataSolution.getNthSubSequenceDigit(10))
        assertEquals(0, KataSolution.getNthSubSequenceDigit(11))
        assertEquals(1, KataSolution.getNthSubSequenceDigit(12))
    }

    @Test
    fun `get sub sequence digit count`() {
        assertEquals(9, KataSolution.getSubSequenceDigitCount(9))
        assertEquals(9 + 90 * 2, KataSolution.getSubSequenceDigitCount(99))
        assertEquals(9 + 90 * 2 + 2 * 3, KataSolution.getSubSequenceDigitCount(101))
        assertEquals(9 + 90 * 2 + 401 * 3, KataSolution.getSubSequenceDigitCount(500))
        assertEquals(9 + 90 * 2 + 900 * 3 + 202 * 4, KataSolution.getSubSequenceDigitCount(1201))
    }
}