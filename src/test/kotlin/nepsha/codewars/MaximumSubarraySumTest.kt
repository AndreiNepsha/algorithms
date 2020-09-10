package nepsha.codewars

import org.junit.Test
import kotlin.test.assertEquals

class MaximumSubarraySumTest {
    @Test
    fun `it should work on an empty list`() {
        assertEquals(0, MaximumSubarraySum.maxSequence(emptyList()))
    }

    @Test
    fun `it should work on the example`() {
        assertEquals(6, MaximumSubarraySum.maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }
}