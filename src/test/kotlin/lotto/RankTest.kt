package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `returns FIRST when matchCount is 6`() {
        val rank = Rank.from(6, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND when matchCount is 5 and bonus matches`() {
        val rank = Rank.from(5, bonusMatch = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD when matchCount is 5 without bonus`() {
        val rank = Rank.from(5, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH when matchCount is 4`() {
        val rank = Rank.from(4, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH when matchCount is 3`() {
        val rank = Rank.from(3, bonusMatch = true)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns NONE when matchCount is less than 3`() {
        assertThat(Rank.from(2, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.from(1, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.from(0, true)).isEqualTo(Rank.NONE)
    }
}
