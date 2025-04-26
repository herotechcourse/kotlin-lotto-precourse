package lotto

import lotto.domain.LottoResult
import lotto.domain.Prize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `returns correct prize count for a given prize`() {
        val prizeCounts = mapOf(
            Prize.FIRST to 1,
            Prize.SECOND to 2,
            Prize.THIRD to 0
        )
        val lottoResult = LottoResult(prizeCounts)

        assertEquals(1, lottoResult.getPrizeCount(Prize.FIRST))
        assertEquals(2, lottoResult.getPrizeCount(Prize.SECOND))
        assertEquals(0, lottoResult.getPrizeCount(Prize.THIRD))
    }

    @Test
    fun `returns zero for a prize not in the result`() {
        val prizeCounts = mapOf(
            Prize.FIRST to 1,
            Prize.SECOND to 2
        )
        val lottoResult = LottoResult(prizeCounts)

        assertEquals(0, lottoResult.getPrizeCount(Prize.THIRD))
    }

    @Test
    fun `calculates total winnings correctly`() {
        val prizeCounts = mapOf(
            Prize.FIRST to 1,  // Prize.FIRST.amount = e.g., 2_000_000_000
            Prize.SECOND to 2  // Prize.SECOND.amount = e.g., 30_000_000
        )
        val lottoResult = LottoResult(prizeCounts)

        val expectedTotalWinnings = 
            Prize.FIRST.amount * 1 + Prize.SECOND.amount * 2
        assertEquals(expectedTotalWinnings, lottoResult.getTotalWinnings())
    }
}