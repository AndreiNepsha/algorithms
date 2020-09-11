package nepsha.codewars

import org.junit.Test
import kotlin.test.assertEquals

class BlockSequenceTest {
    private fun runTest(n:Long, sol:Int) = assertEquals(sol, BlockSequence.solve(n))

    @Test
    fun `Basic Test Cases`() {
        runTest(1L,1)
        runTest(2L,1)
        runTest(3L,2)
        runTest(7L,1)
        runTest(10L,4)
        runTest(20L,5)
        runTest(100L,1)
        runTest(2100L,2)
        runTest(31000L,2)
        runTest(999999999999999999L,4)
        runTest(1000000000000000000L,1)
        runTest(999999999999999993L,7)
    }

    @Test
    fun `getNthSubSequenceDigit`() {
        assertEquals(5, BlockSequence.getNthSubSequenceDigit(5))
        assertEquals(9, BlockSequence.getNthSubSequenceDigit(9))
        assertEquals(1, BlockSequence.getNthSubSequenceDigit(10))
        assertEquals(0, BlockSequence.getNthSubSequenceDigit(11))
        assertEquals(1, BlockSequence.getNthSubSequenceDigit(12))
    }

    @Test
    fun `calculateSubsequenceDigits`() {
        assertEquals(1, BlockSequence.calculateSequenceDigits(1))
        assertEquals(45, BlockSequence.calculateSequenceDigits(9))
        assertEquals(101, BlockSequence.calculateSequenceDigits(13))
        assertEquals(141, BlockSequence.calculateSequenceDigits(15))
        assertEquals(9045, BlockSequence.calculateSequenceDigits(99))
        assertEquals(9045 + 192, BlockSequence.calculateSequenceDigits(100))
        assertEquals(9045 + 192 + 195, BlockSequence.calculateSequenceDigits(101))
    }
}