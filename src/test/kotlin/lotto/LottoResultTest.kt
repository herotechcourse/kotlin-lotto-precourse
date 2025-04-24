package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7

    @Test
    fun `returns FIRST rank for 6 matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val statistic = result.getStatistics()
        assertThat(statistic[LottoRank.FIRST]).isEqualTo(1)
    }

    @Test
    fun `returns SECOND rank for 5 matches and bonus`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val statistic = result.getStatistics()
        assertThat(statistic[LottoRank.SECOND]).isEqualTo(1)
    }

    @Test
    fun `returns THIRD rank for 5 matches without bonus`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val statistic = result.getStatistics()
        assertThat(statistic[LottoRank.THIRD]).isEqualTo(1)
    }

    @Test
    fun `returns FOURTH rank for 4 matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 9, 10))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val statistic = result.getStatistics()
        assertThat(statistic[LottoRank.FOURTH]).isEqualTo(1)
    }

    @Test
    fun `returns FIFTH rank for 3 matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 10, 11, 12))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val statistic = result.getStatistics()
        assertThat(statistic[LottoRank.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `does not include MISS rank in statistics`() {
        val lotto = Lotto(listOf(1, 2, 10, 11, 12, 13))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val statistic = result.getStatistics()
        assertThat(statistic).doesNotContainKey(LottoRank.MISS)
    }

    @Test
    fun `calculateReturnRate should return 100 percent when prize equals purchase`() {
        val lotto = Lotto(listOf(1, 2, 3, 10, 11, 12))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val returnRate = result.calculateReturnRate(5000)
        assertThat(returnRate).isEqualTo(100.0)
    }

    @Test
    fun `calculateReturnRate should return 0 percent when no match`() {
        val lotto = Lotto(listOf(10, 11, 12, 13, 14, 15))
        val result = LottoResult(winningNumbers, bonusNumber)

        result.analyzeResult(listOf(lotto))
        val returnRate = result.calculateReturnRate(1000)
        assertThat(returnRate).isEqualTo(0.0)
    }


    @Test
    fun `getStatistics should return empty map when there are no winners`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lottoTickets = listOf(
            Lotto(listOf(10, 11, 12, 13, 14, 15)),
            Lotto(listOf(16, 17, 18, 19, 20, 21))
        )

        val lottoResult = LottoResult(winningNumbers, bonusNumber)
        lottoResult.analyzeResult(lottoTickets)
        val statistics = lottoResult.getStatistics()

        assertThat(statistics).isEmpty()
    }

}