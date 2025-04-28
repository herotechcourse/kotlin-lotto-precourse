package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `return matching Rank when exact match`() {
        assertEquals(Rank.FIRST, Rank.matching(6, false))
        assertEquals(Rank.SECOND, Rank.matching(5, true))
        assertEquals(Rank.THIRD, Rank.matching(5, false))
        assertEquals(Rank.FOURTH, Rank.matching(4, false))
        assertEquals(Rank.FIFTH, Rank.matching(3, false))
        assertEquals(Rank.NONE, Rank.matching(0, false))
    }
}