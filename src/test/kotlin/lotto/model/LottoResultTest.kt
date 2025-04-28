package lotto.model

import lotto.Lotto
import lotto.constants.Constants
import lotto.constants.Prize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTest {
    private val purchaseCount = 7
    private val lottery = listOf(
        Lotto(listOf(9, 21, 24, 30, 33, 37)), // 6 matches
        Lotto(listOf(9, 21, 24, 30, 33, 29)), // 5 matches + bonus
        Lotto(listOf(9, 21, 24, 30, 33, 45)), // 5 matches
        Lotto(listOf(9, 21, 24, 30, 31, 34)), // 4 matches
        Lotto(listOf(9, 21, 24, 11, 12, 13)), // 3 matches
        Lotto(listOf(1, 2, 9, 15, 16, 37)), // 2 matches
        Lotto(listOf(8, 22, 25, 31, 34, 38)) // 0 matches
    )
    private val lottoStorage = LottoStorage(lottery)
    private val winningLotto = WinningLotto(Lotto(listOf(9, 21, 24, 30, 33, 37)), 29)
    private val lottoResult = LottoResult(lottoStorage, winningLotto)

    @Test
    fun `getCount - returns correct count of each LottoRank`() {
        assertEquals(1, lottoResult.getCount(LottoRank.FIRST))
        assertEquals(1, lottoResult.getCount(LottoRank.SECOND))
        assertEquals(1, lottoResult.getCount(LottoRank.THIRD))
        assertEquals(1, lottoResult.getCount(LottoRank.FOURTH))
        assertEquals(1, lottoResult.getCount(LottoRank.FIFTH))
        assertEquals(2, lottoResult.getCount(LottoRank.NOTHING))
    }

    @Test
    fun `calculateProfitRate - returns the correct profit rate calculation`() {
        val purchaseAmount = purchaseCount * Constants.LOTTO_PURCHASE_UNIT
        val expectedTotalPrize = Prize.FIRST + Prize.SECOND + Prize.THIRD + Prize.FOURTH + Prize.FIFTH
        val expectedProfitRate =
            String.format("%.1f", (expectedTotalPrize.toDouble() / purchaseAmount) * 100).toDouble()

        assertEquals(expectedProfitRate, lottoResult.calculateProfitRate(purchaseAmount))
    }
}