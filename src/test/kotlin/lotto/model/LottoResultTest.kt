package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `initializes with zero counts`() {
        val result = LottoResult()

        Rank.values().forEach { rank ->
            assertThat(result.getRankCount(rank)).isEqualTo(0)
        }
    }

    @Test
    fun `adds rank counts correctly`() {
        val result = LottoResult()

        // Add ranks
        result.addRank(Rank.FIRST)
        result.addRank(Rank.THIRD)
        result.addRank(Rank.THIRD)
        result.addRank(Rank.FIFTH)
        result.addRank(Rank.FIFTH)
        result.addRank(Rank.FIFTH)

        // Check counts
        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1)
        assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(0)
        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(2)
        assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(0)
        assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(3)
        assertThat(result.getRankCount(Rank.NONE)).isEqualTo(0)
    }

    @Test
    fun `calculates total prize correctly`() {
        val result = LottoResult()

        // Add ranks
        result.addRank(Rank.FIRST) // 2,000,000,000
        result.addRank(Rank.THIRD) // 1,500,000
        result.addRank(Rank.THIRD) // 1,500,000
        result.addRank(Rank.FIFTH) // 5,000
        result.addRank(Rank.FIFTH) // 5,000
        result.addRank(Rank.FIFTH) // 5,000

        // Expected total: 2,000,000,000 + (1,500,000 * 2) + (5,000 * 3) = 2,003,015,000
        assertThat(result.getTotalPrize()).isEqualTo(2_003_015_000)
    }

    @Test
    fun `calculates profit rate correctly`() {
        val result = LottoResult()

        // Add one Fifth rank (5,000 won)
        result.addRank(Rank.FIFTH)

        // Purchase amount: 8,000 won
        // Total prize: 5,000 won
        // Profit rate: (5,000 / 8,000) * 100 = 62.5%
        assertThat(result.calculateProfitRate(8000)).isEqualTo(62.5)
    }

    @Test
    fun `handles zero purchase amount`() {
        val result = LottoResult()

        result.addRank(Rank.FIFTH)

        assertThat(result.calculateProfitRate(0)).isEqualTo(0.0)
    }
}