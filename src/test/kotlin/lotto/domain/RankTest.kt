package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `returns FIRST when matchCount is 6`() {

        val rank = Rank.of(6, hasBonus = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND when matchCount is 5 and bonus`() {

        val rank = Rank.of(5, hasBonus = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD when matchCount is 5 without bonus`() {

        val rank = Rank.of(5, hasBonus = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH when matchCount is 4`() {

        val rank = Rank.of(4, hasBonus = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH when matchCount is 3`() {
        val rank = Rank.of(3, hasBonus = false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns NONE when matchCount is less than 3`() {
        val rankZero = Rank.of(0, hasBonus = false)
        val rankTwo = Rank.of(1, hasBonus = false)

        assertThat(rankZero).isEqualTo(Rank.NONE)
        assertThat(rankTwo).isEqualTo(Rank.NONE)
    }
}