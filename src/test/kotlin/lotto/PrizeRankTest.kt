package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class PrizeRankTest {

    @Test
    fun `first prize when match 6`() {
        val rank = PrizeRank.findByMatch(6, false)
        assertThat(rank).isEqualTo(PrizeRank.FIRST)
    }

    @Test
    fun `second prize when match 5 with bonus`() {
        val rank = PrizeRank.findByMatch(5, true)
        assertThat(rank).isEqualTo(PrizeRank.SECOND)
    }

    @Test
    fun `third prize when match 5 without bonus`() {
        val rank = PrizeRank.findByMatch(5, false)
        assertThat(rank).isEqualTo(PrizeRank.THIRD)
    }

    @Test
    fun `fourth prize when match 4`() {
        val rank = PrizeRank.findByMatch(4, false)
        assertThat(rank).isEqualTo(PrizeRank.FOURTH)
    }

    @Test
    fun `fifth prize when match 3`() {
        val rank = PrizeRank.findByMatch(3, false)
        assertThat(rank).isEqualTo(PrizeRank.FIFTH)
    }

    @Test
    fun `null when less than 3 matches`() {
        val rank = PrizeRank.findByMatch(2, false)
        assertThat(rank).isNull()
    }
}
