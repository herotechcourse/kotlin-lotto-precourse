package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `should correctly record prize ranks`() {
        val lottoResult = LottoResult()

        lottoResult.record(PrizeRank.FOURTH)
        lottoResult.record(PrizeRank.FOURTH)
        lottoResult.record(PrizeRank.FIFTH)

        val results = lottoResult.getResults()

        assertThat(results[PrizeRank.FOURTH]).isEqualTo(2)
        assertThat(results[PrizeRank.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `should calculate correct profit rate`() {
        val lottoResult = LottoResult()

        lottoResult.record(PrizeRank.FIFTH)
        lottoResult.record(PrizeRank.FIFTH)
        lottoResult.record(PrizeRank.FOURTH)

        val totalSpent = 8000

        val profitRate = lottoResult.calculateProfitRate(totalSpent)

        // 5,000 + 5,000 + 50,000 = 60,000
        // 60,000 / 8,000 * 100 = 750.0%
        assertThat(profitRate).isEqualTo(750.0)
    }
}
