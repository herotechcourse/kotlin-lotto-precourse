package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `returns FIRST for 6 matches`() {
        val rank = Rank.from(matchCount = 6, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND for 5 matches with bonus`() {
        val rank = Rank.from(matchCount = 5, bonusMatch = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD for 5 matches without bonus`() {
        val rank = Rank.from(matchCount = 5, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH for 4 matches`() {
        val rank = Rank.from(matchCount = 4, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH for 3 matches`() {
        val rank = Rank.from(matchCount = 3, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns null for less than 3 matches`() {
        val rank = Rank.from(matchCount = 2, bonusMatch = false)
        assertThat(rank).isNull()
    }
}