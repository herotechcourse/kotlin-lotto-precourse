package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RankTest {
    @Nested
    inner class `determine rank level test` {

        @Test
        fun `match 6 numbers returns FIRST` () {
            val rank = Rank.of(6, hasBonus = false)
            assertThat(rank).isEqualTo(Rank.FIRST)
        }

        @Test
        fun `match 5 numbers with bonus returns SECOND` () {
            val rank = Rank.of(5, hasBonus = true)
            assertThat(rank).isEqualTo(Rank.SECOND)
        }

        @Test
        fun `match 5 numbers without bonus returns THIRD` () {
            val rank = Rank.of(5, hasBonus = false)
            assertThat(rank).isEqualTo(Rank.THIRD)
        }

        @Test
        fun `match 4 numbers returns FOURTH` () {
            val rank = Rank.of(4, hasBonus = false)
            assertThat(rank).isEqualTo(Rank.FOURTH)
        }

        @Test
        fun `match 3 numbers returns FIFTH` () {
            val rank = Rank.of(3, hasBonus = false)
            assertThat(rank).isEqualTo(Rank.FIFTH)
        }

        @Test
        fun `match less than 3 numbers returns NONE`() {
            val rank = Rank.of(2, hasBonus = false)
            assertThat(rank).isEqualTo(Rank.NONE)
        }
    }
}