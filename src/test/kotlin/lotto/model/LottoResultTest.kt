package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `calculates total prize correctly`() {
        val results = mapOf(
            PrizeRank.FIRST to 1,
            PrizeRank.SECOND to 1,
            PrizeRank.THIRD to 1,
            PrizeRank.FOURTH to 2,
            PrizeRank.FIFTH to 3,
            PrizeRank.NONE to 0
        )

        val lottoResult = LottoResult(results, 10)
        val expectedPrize = PrizeRank.FIRST.prize +
                PrizeRank.SECOND.prize +
                PrizeRank.THIRD.prize +
                (PrizeRank.FOURTH.prize * 2) +
                (PrizeRank.FIFTH.prize * 3)

        assertThat(lottoResult.getTotalPrize()).isEqualTo(expectedPrize)
    }
    @Test
    fun `calculates profit rate correctly`() {
        val results = mapOf(
            PrizeRank.FIFTH to 1,
            PrizeRank.NONE to 0
        )

        val lottoResult = LottoResult(results, 1)
        // 1 ticket costs 1000, fifth prize is 5000, so profit rate is 500%
        assertThat(lottoResult.getProfitRate()).isEqualTo(500.0)
    }
}