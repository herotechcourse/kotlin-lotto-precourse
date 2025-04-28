package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `returns FIRST rank when 6 numbers match`() {
        val rank = Rank.findRank(matchCount = 6, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND rank when 5 numbers match and bonus number matches`() {
        val rank = Rank.findRank(matchCount = 5, bonusMatch = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD rank when 5 numbers match without bonus`() {
        val rank = Rank.findRank(matchCount = 5, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH rank when 4 numbers match`() {
        val rank = Rank.findRank(matchCount = 4, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH rank when 3 numbers match`() {
        val rank = Rank.findRank(matchCount = 3, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns null when less than 3 numbers match`() {
        val rank = Rank.findRank(matchCount = 2, bonusMatch = false)
        assertThat(rank).isNull()
    }
}
