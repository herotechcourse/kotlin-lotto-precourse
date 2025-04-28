package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `match 6 numbers returns FIRST`() {
        val rank = Rank.from(6, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `match 5 numbers with bonus returns SECOND`() {
        val rank = Rank.from(5, bonusMatch = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `match 5 numbers without bonus returns THIRD`() {
        val rank = Rank.from(5, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `match 4 numbers returns FOURTH`() {
        val rank = Rank.from(4, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `match 3 numbers returns FIFTH`() {
        val rank = Rank.from(3, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `match less than 3 numbers returns NONE`() {
        val rank = Rank.from(2, bonusMatch = false)
        assertThat(rank).isEqualTo(Rank.NONE)
    }
}
