package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MatchResultsTest {
    @Test
    fun `returns correct count for a given MatchRank`() {
        val matchResults = MatchResults(
            mapOf(
                MatchRank.FIRST to 1,
                MatchRank.FIFTH to 2
            )
        )

        assertThat(matchResults.countOf(MatchRank.FIRST)).isEqualTo(1)
        assertThat(matchResults.countOf(MatchRank.FIFTH)).isEqualTo(2)
        assertThat(matchResults.countOf(MatchRank.SECOND)).isEqualTo(0) // if not matched, return 0
    }

    @Test
    fun `calculates total profit rate correctly`() {
        val matchResults = MatchResults(
            mapOf(
                MatchRank.FIFTH to 1,  // 5,000 KRW
                MatchRank.FOURTH to 1  // 50,000 KRW
            )
        )

        // Purchase cost = 2 tickets × 1,000 KRW = 2,000 KRW
        // Total prize = 5,000 + 50,000 = 55,000 KRW
        // Profit rate = (55,000 ÷ 2,000) = 27.5

        val profitRate = matchResults.profitRate()

        assertThat(profitRate).isEqualTo(27.5)
    }
}
