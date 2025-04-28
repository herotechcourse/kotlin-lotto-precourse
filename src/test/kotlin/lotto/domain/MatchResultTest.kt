package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MatchResultTest {

    @Test
    fun `givenRanks_whenCreateMatchResult_thenCountRanksCorrectly`() {
        val ranks = listOf(
            Rank.FIRST,
            Rank.SECOND,
            Rank.SECOND,
            Rank.THIRD,
            Rank.THIRD,
            Rank.THIRD,
            Rank.FOURTH,
            Rank.FOURTH,
            Rank.FOURTH,
            Rank.FOURTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH
        )

        val matchResult = MatchResult(ranks)

        assertEquals(1, matchResult.getCount(Rank.FIRST))
        assertEquals(2, matchResult.getCount(Rank.SECOND))
        assertEquals(3, matchResult.getCount(Rank.THIRD))
        assertEquals(4, matchResult.getCount(Rank.FOURTH))
        assertEquals(5, matchResult.getCount(Rank.FIFTH))
        assertEquals(0, matchResult.getCount(Rank.MISS))
    }

    @Test
    fun `givenMatchResult_whenCalculateTotalPrize_thenReturnCorrectSum`() {
        val ranks = listOf(
            Rank.FIRST,
            Rank.SECOND,
            Rank.SECOND,
            Rank.THIRD,
            Rank.THIRD,
            Rank.THIRD,
            Rank.FOURTH,
            Rank.FOURTH,
            Rank.FOURTH,
            Rank.FOURTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH
        )
        val matchResult = MatchResult(ranks)

        val totalPrize = matchResult.totalPrize()

        val expected = 2000000000 + (30000000 * 2) + (1500000 * 3) + (50000 * 4) + (5000 * 5)
        assertEquals(expected, totalPrize)
    }

    @Test
    fun `givenMatchResultAndPurchaseAmount_whenCalculateProfitRate_thenReturnCorrectRate`() {
        val ranks = listOf(
            Rank.FOURTH,
            Rank.FOURTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.FIFTH
        )
        val matchResult = MatchResult(ranks)
        val purchaseAmount = 120000

        val profitRate = matchResult.profitRate(purchaseAmount)

        val expectedProfitRate = matchResult.totalPrize().toDouble() / purchaseAmount * 100
        assertEquals(expectedProfitRate, profitRate)
    }
}