package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `find returns FIRST for 6 matches`() {
        val rank = Rank.find(6, false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `find returns SECOND for 5 matches with bonus`() {
        val rank = Rank.find(5, true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `find returns THIRD for 5 matches without bonus`() {
        val rank = Rank.find(5, false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `find returns FOURTH for 4 matches`() {
        val rank = Rank.find(4, false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `find returns FIFTH for 3 matches`() {
        val rank = Rank.find(3, false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `find returns MISS for less than 3 matches`() {
        val rankZero = Rank.find(2, false)
        val rankOne = Rank.find(1, false)
        val rankNone = Rank.find(0, false)

        assertThat(rankZero).isEqualTo(Rank.MISS)
        assertThat(rankOne).isEqualTo(Rank.MISS)
        assertThat(rankNone).isEqualTo(Rank.MISS)
    }
}
