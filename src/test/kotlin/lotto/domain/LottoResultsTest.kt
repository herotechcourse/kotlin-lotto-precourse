package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultsTest {

    @Test
    fun `should count ranks correctly`() {
        val purchasedLottos = listOf(
            Lotto(listOf(3, 5, 11, 16, 32, 38)), // 2
            Lotto(listOf(1, 8, 11, 31, 41, 42)), // 1
            Lotto(listOf(1, 3, 5, 14, 22, 45)) // 3
        )

        val winningLotto = WinningLotto(listOf(1,2,3,4,5,6), 7)
        val results = LottoResults(purchasedLottos, winningLotto)

        assertThat(results.getCount(PrizeRank.FIRST)).isEqualTo(0)
        assertThat(results.getCount(PrizeRank.FIFTH)).isEqualTo(1)
    }

    @Test
    fun `should calculate profit rate correctly`() {
        val purchasedAmount = 8000
        val purchasedLottosFor5kWin = listOf(Lotto(listOf(1, 2, 3, 10, 11, 12)))
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val results = LottoResults(purchasedLottosFor5kWin, winningLotto)

        val expectedProfitRate = 62.5
        val actualProfitRate = results.getprofitRate(purchasedAmount)
        assertThat(actualProfitRate).isEqualTo(expectedProfitRate)
    }
}