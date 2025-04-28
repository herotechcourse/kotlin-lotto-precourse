package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `match 6 numbers should return FIRST`() {
        val rank = Rank.of(6, false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `match 5 numbers with bonus should return SECOND`() {
        val rank = Rank.of(5, true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `match 5 numbers without bonus should return THIRD`() {
        val rank = Rank.of(5, false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `match 4 numbers should return FOURTH`() {
        val rank = Rank.of(4, false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `match 3 numbers should return FIFTH`() {
        val rank = Rank.of(3, false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `match less than 3 numbers should return MISS`() {
        val rank = Rank.of(2, false)
        assertThat(rank).isEqualTo(Rank.MISS)
    }
}