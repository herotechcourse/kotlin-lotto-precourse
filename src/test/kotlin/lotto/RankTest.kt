package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RankTest {

    @Test
    fun `should return FIRST for 6 matches`() {
        val result = Rank.getRank(6, bonusMatch = false)
        assertThat(result).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `should return SECOND for 5 matches and bonus`() {
        val result = Rank.getRank(5, bonusMatch = true)
        assertThat(result).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `should return THIRD for 5 matches without bonus`() {
        val result = Rank.getRank(5, bonusMatch = false)
        assertThat(result).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `should return FOURTH for 4 matches`() {
        val result = Rank.getRank(4, bonusMatch = false)
        assertThat(result).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `should return FIFTH for 3 matches`() {
        val result = Rank.getRank(3, bonusMatch = false)
        assertThat(result).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `should return NONE for less than 3 matches`() {
        val result1 = Rank.getRank(2, bonusMatch = true)
        val result2 = Rank.getRank(1, bonusMatch = false)
        val result3 = Rank.getRank(0, bonusMatch = true)

        assertThat(result1).isEqualTo(Rank.NONE)
        assertThat(result2).isEqualTo(Rank.NONE)
        assertThat(result3).isEqualTo(Rank.NONE)
    }
}
