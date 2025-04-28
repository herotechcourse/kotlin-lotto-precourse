package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RankTest {

    @Test
    fun `determine returns FIRST when matchCount is 6`() {
        val rank = Rank.determine(6, hasBonus = false)

        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `determine returns SECOND when matchCount is 5 and hasBonus is true`() {
        val rank = Rank.determine(5, hasBonus = true)

        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `determine returns THIRD when matchCount is 5 and hasBonus is false`() {
        val rank = Rank.determine(5, hasBonus = false)

        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `determine returns FOURTH when matchCount is 4`() {
        val rank = Rank.determine(4, hasBonus = false)

        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `determine returns FIFTH when matchCount is 3`() {
        val rank = Rank.determine(3, hasBonus = false)

        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `determine returns NONE when matchCount is less than 3`() {
        val rankWithTwoMatches = Rank.determine(2, hasBonus = false)
        val rankWithZeroMatches = Rank.determine(0, hasBonus = false)

        assertThat(rankWithTwoMatches).isEqualTo(Rank.NONE)
        assertThat(rankWithZeroMatches).isEqualTo(Rank.NONE)
    }
}
