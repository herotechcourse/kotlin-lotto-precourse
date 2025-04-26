package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningResultTest {
    @Test
    fun `calculate profit`() {
        val lottoRanks = listOf(LottoRank.FIFTH)
        val winningResult = WinningResult(lottoRanks, Budget(8000))

        assertEquals(62.5, winningResult.profit())
    }
}
