package lotto

import lotto.domain.LottoRank
import lotto.domain.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    private val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
    private val bonusNumber = 7
    private val lottoResult = LottoResult(winningNumbers, bonusNumber)

    @Test
    fun `should return FIRST rank when matching 6 numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val rank = lottoResult.calculateRanks(listOf(ticket))
        assertThat(rank).containsExactly(LottoRank.FIRST)
    }

    @Test
    fun `should return SECOND rank when matching 5 numbers plus bonus`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val rank = lottoResult.calculateRanks(listOf(ticket))
        assertThat(rank).containsExactly(LottoRank.SECOND)
    }

    @Test
    fun `should return THIRD rank when matching 5 numbers without bonus`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val rank = lottoResult.calculateRanks(listOf(ticket))
        assertThat(rank).containsExactly(LottoRank.THIRD)
    }

    @Test
    fun `should return FOURTH rank when matching 4 numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val rank = lottoResult.calculateRanks(listOf(ticket))
        assertThat(rank).containsExactly(LottoRank.FOURTH)
    }

    @Test
    fun `should return FIFTH rank when matching 3 numbers`() {
        val ticket = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val rank = lottoResult.calculateRanks(listOf(ticket))
        assertThat(rank).containsExactly(LottoRank.FIFTH)
    }

    @Test
    fun `should return NONE rank when matching less than 3 numbers`() {
        val ticket = Lotto(listOf(10, 20, 30, 40, 41, 42))
        val rank = lottoResult.calculateRanks(listOf(ticket))
        assertThat(rank).containsExactly(LottoRank.NONE)
    }

    @Test
    fun `should count each rank correctly`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
        )
        val ranks = lottoResult.calculateRanks(tickets)
        val statistics = lottoResult.getStatistics(ranks)

        assertThat(statistics[LottoRank.SECOND]).isEqualTo(1)
        assertThat(statistics[LottoRank.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `should correctly count multiple tickets for the same rank`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )
        val ranks = lottoResult.calculateRanks(tickets)
        val statistics = lottoResult.getStatistics(ranks)

        assertThat(statistics[LottoRank.FIRST]).isEqualTo(2)
    }

    @Test
    fun `should calculate total winning amount correctly`() {
        val statistics = mapOf(
            LottoRank.FIRST to 2,
            LottoRank.SECOND to 1
        )
        val totalWinningAmount = lottoResult.calculateWinningAmount(statistics)
        assertThat(totalWinningAmount).isEqualTo(2_000_000_000L * 2 + 30_000_000L)
    }

    @Test
    fun `should calculate return rate correctly`() {
        val totalWinningAmount = 2_000_000_000L * 20 + 30_000_000L
        val purchaseAmount = 10000
        val returnRate = lottoResult.calculateReturnRate(totalWinningAmount, purchaseAmount)
        assertThat(returnRate).isEqualTo(400300000.0)
    }

    @Test
    fun `should calculate return rate with one decimal place`() {
        val totalWinningAmount = 30_000_000L + 5_000L
        val purchaseAmount = 13000
        val returnRate = lottoResult.calculateReturnRate(totalWinningAmount, purchaseAmount)
        val formattedReturnRate = "%.1f".format(returnRate)
        assertThat(formattedReturnRate).isEqualTo("230807.7")
    }
}
