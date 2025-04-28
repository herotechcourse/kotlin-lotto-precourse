package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeRankCriteriaTest {
    @Test
    fun `match 6 numbers returns FIRST rank`() {
        val result = PrizeRankCriteria.rank(6, false)
        assertEquals(PrizeRankCriteria.FIRST, result)
    }

    @Test
    fun `match 5 numbers with bonus returns SECOND rank`() {
        val result = PrizeRankCriteria.rank(5, true)
        assertEquals(PrizeRankCriteria.SECOND, result)
    }

    @Test
    fun `match 5 numbers without bonus returns THIRD rank`() {
        val result = PrizeRankCriteria.rank(5, false)
        assertEquals(PrizeRankCriteria.THIRD, result)
    }

    @Test
    fun `match 4 numbers without bonus returns FOURTH rank`() {
        val result = PrizeRankCriteria.rank(4, false)
        assertEquals(PrizeRankCriteria.FOURTH, result)
    }

    @Test
    fun `match 3 numbers without bonus returns FIFTH rank`() {
        val result = PrizeRankCriteria.rank(3, false)
        assertEquals(PrizeRankCriteria.FIFTH, result)
    }

    @Test
    fun `match 2 numbers returns NONE`() {
        val result = PrizeRankCriteria.rank(2, false)
        assertEquals(PrizeRankCriteria.NONE, result)
    }
}