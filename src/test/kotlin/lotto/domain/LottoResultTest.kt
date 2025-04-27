package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `countOf returns correct count for each rank`() {
        val rankCount = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 2
        )
        val lottoResult = LottoResult(rankCount)
        assertThat(lottoResult.countOf(Rank.FIRST)).isEqualTo(1)
        assertThat(lottoResult.countOf(Rank.SECOND)).isEqualTo(2)
        assertThat(lottoResult.countOf(Rank.THIRD)).isEqualTo(0)
    }

    @Test
    fun `totalReward returns the correct sum of rewards`() {

        val rankCount = mapOf(
            Rank.FIRST to 1,
            Rank.THIRD to 3
        )
        val lottoResult = LottoResult(rankCount)


        val totalReward = lottoResult.totalReward()


        assertThat(totalReward).isEqualTo(2000000000 + 1500000 * 3)
    }

    @Test
    fun `profitRate calculates the correct profit percentage`() {

        val rankCount = mapOf(
            Rank.THIRD to 1
        )
        val lottoResult = LottoResult(rankCount)
        val purchaseAmount = 10000

        val profitRate = lottoResult.profitRate(purchaseAmount)


        assertThat(profitRate).isEqualTo(15000.0)
    }
}