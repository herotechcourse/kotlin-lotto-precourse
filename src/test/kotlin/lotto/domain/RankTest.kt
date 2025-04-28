package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `valueOf should return FIFTH for 3 matches without bonus`() {
        assertThat(Rank.valueOf(matchCount = 3, bonus = false)).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `valueOf should return FOURTH for 4 matches without bonus`() {
        assertThat(Rank.valueOf(matchCount = 4, bonus = false)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `valueOf should return THIRD for 5 matches without bonus`() {
        assertThat(Rank.valueOf(matchCount = 5, bonus = false)).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `valueOf should return SECOND for 5 matches with bonus`() {
        assertThat(Rank.valueOf(matchCount = 5, bonus = true)).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `valueOf should return FIRST for 6 matches without bonus`() {
        assertThat(Rank.valueOf(matchCount = 6, bonus = false)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `valueOf should return null for invalid combinations`() {
        assertThat(Rank.valueOf(matchCount = 2, bonus = false)).isNull()
        assertThat(Rank.valueOf(matchCount = 6, bonus = true)).isNull()
    }
}
