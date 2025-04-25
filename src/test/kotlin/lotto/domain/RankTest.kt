package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `returns FIRST rank for 6 matches`() {
        val rank = Rank.of(6, false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND rank for 5 matches and bonus match`() {
        val rank = Rank.of(5, true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD rank for 5 matches without bonus`() {
        val rank = Rank.of(5, false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH rank for 4 matches`() {
        val rank = Rank.of(4, false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH rank for 3 matches`() {
        val rank = Rank.of(3, false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns NONE rank for less than 3 matches`() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(1, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(0, false)).isEqualTo(Rank.NONE)
    }
}