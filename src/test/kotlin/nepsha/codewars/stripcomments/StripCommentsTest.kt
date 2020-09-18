package nepsha.codewars.stripcomments

import org.junit.Test
import kotlin.test.assertEquals

class StripCommentsTest {
    @Test
    fun testFixed() {
        assertEquals("apples, plums\npears\noranges", solution("apples, plums % and bananas\npears\noranges !applesauce", charArrayOf('%', '!')))
        assertEquals("Q\nu\ne", solution("Q @b\nu\ne -e f g", charArrayOf('@', '-')))
    }
}