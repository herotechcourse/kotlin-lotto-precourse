package lotto.domain

import lotto.domain.PrizeRank
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class PrizeRankBusinessTest {
    @Test
    fun `determine first prize correctly`() {
        assertEquals(PrizeRank.FIRST, PrizeRank.determineRank(6, false))
    }

    @Test
    fun `determine second prize correctly`() {
        assertEquals(PrizeRank.SECOND, PrizeRank.determineRank(5, true))
    }

    @Test
    fun `determine third prize correctly`() {
        assertEquals(PrizeRank.THIRD, PrizeRank.determineRank(5, false))
    }

    @Test
    fun `determine fourth prize correctly`() {
        assertEquals(PrizeRank.FOURTH, PrizeRank.determineRank(4, false))
    }

    @Test
    fun `determine fifth prize correctly`() {
        assertEquals(PrizeRank.FIFTH, PrizeRank.determineRank(3, false))
    }

    @Test
    fun `determine no prize correctly`() {
        assertEquals(PrizeRank.NONE, PrizeRank.determineRank(2, false))
        assertEquals(PrizeRank.NONE, PrizeRank.determineRank(1, true))
    }

    @Test
    fun `check prize amounts`() {
        assertEquals(2_000_000_000, PrizeRank.FIRST.prizeAmount)
        assertEquals(30_000_000, PrizeRank.SECOND.prizeAmount)
        assertEquals(1_500_000, PrizeRank.THIRD.prizeAmount)
        assertEquals(50_000, PrizeRank.FOURTH.prizeAmount)
        assertEquals(5_000, PrizeRank.FIFTH.prizeAmount)
        assertEquals(0, PrizeRank.NONE.prizeAmount)
    }
} 