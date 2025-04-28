package lotto.domain

import lotto.Lotto
import lotto.LottoRank
import lotto.LottoResult
import lotto.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {

    @Test
    fun `calculateStatistics should calculate winning statistics correctly`() {
        // given
        val purchaseAmount = 8000
        val lottoResult = LottoResult(purchaseAmount)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),     // 1st Prize
            Lotto(listOf(1, 2, 3, 4, 5, 7)),     // 2nd Prize
            Lotto(listOf(1, 2, 3, 4, 5, 8)),     // 3rd Prize
            Lotto(listOf(1, 2, 3, 4, 8, 9)),     // 4th Prize
            Lotto(listOf(1, 2, 3, 8, 9, 10)),    // 5th Prize
            Lotto(listOf(1, 2, 8, 9, 10, 11)),   // No win
            Lotto(listOf(8, 9, 10, 11, 12, 13)), // No win
            Lotto(listOf(1, 2, 3, 4, 5, 6))      // 1st Prize (duplicate)
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        // when
        lottoResult.calculateStatistics(lottos, winningLotto)
        val results = lottoResult.getResults()

        // then
        assertThat(results[LottoRank.FIRST]).isEqualTo(2)
        assertThat(results[LottoRank.SECOND]).isEqualTo(1)
        assertThat(results[LottoRank.THIRD]).isEqualTo(1)
        assertThat(results[LottoRank.FOURTH]).isEqualTo(1)
        assertThat(results[LottoRank.FIFTH]).isEqualTo(1)
        assertThat(results[LottoRank.MISS]).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource(
        "8000, 62.5", // One 5th prize (5000 KRW)
        "1000, 0.0"   // No win (0 KRW)
    )
    fun `calculateProfitRate should calculate the profit rate correctly`(purchaseAmount: Int, expectedRate: Double) {
        // given
        val lottoResult = LottoResult(purchaseAmount)
        if (purchaseAmount == 8000) {
            lottoResult.recordWinning(LottoRank.FIFTH) // Add one 5th prize win
        }

        // when
        val profitRate = lottoResult.calculateProfitRate()

        // then
        assertThat(profitRate).isEqualTo(expectedRate)
    }

    @Test
    fun `calculateProfitRate should return 0_0 when the purchase amount is zero`() {
        // given
        val lottoResult = LottoResult(0)
        lottoResult.recordWinning(LottoRank.FIRST) // Even with winnings, profit rate is 0 if purchase amount is 0

        // when
        val profitRate = lottoResult.calculateProfitRate()

        // then
        assertThat(profitRate).isEqualTo(0.0)
    }
} 