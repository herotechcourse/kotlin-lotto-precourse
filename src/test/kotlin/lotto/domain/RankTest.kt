package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `returns FIRST when six numbers match`() {
        val rank = Rank.of(6, false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND when five numbers match and bonus is matched`() {
        val rank = Rank.of(5, true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD when five numbers match and bonus is not matched`() {
        val rank = Rank.of(5, false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH when four numbers match`() {
        val rank = Rank.of(4, false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH when three numbers match`() {
        val rank = Rank.of(3, false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns NONE when less than three numbers match`() {
        val rankTwoMatches = Rank.of(2, false)
        val rankOneMatch = Rank.of(1, false)
        val rankZeroMatch = Rank.of(0, false)

        assertThat(rankTwoMatches).isEqualTo(Rank.NONE)
        assertThat(rankOneMatch).isEqualTo(Rank.NONE)
        assertThat(rankZeroMatch).isEqualTo(Rank.NONE)
    }
}
