package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoResultTest {

    @Test
    fun `returns correct win count for rank`() {
        val rankCounts = mapOf(
            LottoGrade.FIRST to 1,
            LottoGrade.THIRD to 2,
            LottoGrade.FIFTH to 3
        )
        val result = LottoResult(rankCounts)

        assertEquals(1, result.getWinCount(LottoGrade.FIRST))
        assertEquals(2, result.getWinCount(LottoGrade.THIRD))
        assertEquals(3, result.getWinCount(LottoGrade.FIFTH))
        assertEquals(0, result.getWinCount(LottoGrade.SECOND))
    }

    @Test
    fun `calculates correct total prize`() {
        val rankCounts = mapOf(
            LottoGrade.FIRST to 1,
            LottoGrade.THIRD to 2,
            LottoGrade.FIFTH to 3
        )
        val result = LottoResult(rankCounts)
        assertEquals(2003015000.0, result.calculateReturnRate(1000) * 1000 / 100)
    }

    @Test
    fun `calculates correct return rate`() {
        val rankCounts = mapOf(
            LottoGrade.FOURTH to 1,
            LottoGrade.FIFTH to 2
        )
        val result = LottoResult(rankCounts)
        val purchaseAmount = 1000
        val expectedRate = (50000 + 10000).toDouble() / purchaseAmount * 100
        assertEquals(expectedRate, result.calculateReturnRate(purchaseAmount))
    }
}