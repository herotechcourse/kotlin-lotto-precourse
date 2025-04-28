package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `getRankCounts returns correct counts`() {
        val lottoResult = LottoResult(
            listOf(Ranks.FIRST, Ranks.FOURTH, Ranks.FOURTH, Ranks.NONE)
        )

        val counts = lottoResult.getRankCounts()

        assertEquals(1, counts[Ranks.FIRST])
        assertEquals(2, counts[Ranks.FOURTH])
        assertEquals(1, counts[Ranks.NONE])
    }

    @Test
    fun `totalPrize sums prize money correctly`() {
        val lottoResult = LottoResult(
            listOf(Ranks.FIRST, Ranks.FOURTH, Ranks.FOURTH, Ranks.NONE)
        )

        val totalPrize = lottoResult.totalPrize()

        val expectedPrize = 2_000_000_000 + 50_000 + 50_000 + 0
        assertEquals(expectedPrize, totalPrize)
    }
}