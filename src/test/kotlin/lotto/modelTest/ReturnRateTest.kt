package lotto.modelTest

import lotto.model.LottoService
import lotto.model.Rank
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ReturnRateTest {

    @Test
    fun `return rate with no winners should be 0`() {
        val lottoService = LottoService()

        val rankCounts = mapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0,
            Rank.NONE to 5
        )

        val purchaseAmount = 5000
        val returnRate = lottoService.calculateReturnRate(rankCounts, purchaseAmount)

        assertThat(returnRate).isEqualTo(0.0)
    }

    @Test
    fun `calculate return rate with winner tickets in mixed ranks`() {
        val lottoService = LottoService()

        val rankCounts = mapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 0,
            Rank.THIRD to 2,
            Rank.FOURTH to 2,
            Rank.FIFTH to 2,
            Rank.NONE to 4
        )

        val purchaseAmount = 10000
        val returnRate = lottoService.calculateReturnRate(rankCounts, purchaseAmount)

        assertThat(returnRate).isEqualTo(31_100.0)
    }

    @Test
    fun `calculate return rate with all winners in first rank`() {
        val lottoService = LottoService()

        val rankCounts = mapOf(
            Rank.FIRST to 2,
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0,
            Rank.NONE to 0
        )

        val purchaseAmount = 2000
        val returnRate = lottoService.calculateReturnRate(rankCounts, purchaseAmount)
        assertThat(returnRate).isEqualTo(200_000_000.0)
    }

    @Test
    fun `calculate return rate with a single winner ticket`() {
        val lottoService = LottoService()

        val rankCounts = mapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 1,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0,
            Rank.NONE to 1
        )

        val purchaseAmount = 2000
        val returnRate = lottoService.calculateReturnRate(rankCounts, purchaseAmount)

        assertThat(returnRate).isEqualTo(1_500_000.0)
    }
}