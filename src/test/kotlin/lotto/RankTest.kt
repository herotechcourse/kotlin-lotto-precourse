package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RankTest {
    /**
     * Tests for Rank.from(matchCount = 6)
     * - Bonus number irrelevant when all 6 numbers match
     * - Always returns FIRST
     */
    @Test
    fun `returns FIRST when 6 numbers match`() {
        assertThat(Rank.from(6, true)).isEqualTo(Rank.FIRST)
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST)
    }

    /**
     * Tests for Rank.from(matchCount = 5)
     * - Returns SECOND if bonus matches
     * - Returns THIRD if bonus does not match
     */
    @Test
    fun `returns SECOND when 5 numbers match and bonus matches`() {
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD when 5 numbers match and bonus does not match`() {
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD)
    }

    /**
     * Tests for Rank.from(matchCount = 4)
     * - Bonus is ignored
     * - Always returns FOURTH
     */
    @Test
    fun `returns FOURTH when 4 numbers match`() {
        assertThat(Rank.from(4, true)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH)
    }

    /**
     * Tests for Rank.from(matchCount = 3)
     * - Bonus is ignored
     * - Always returns FIFTH
     */
    @Test
    fun `returns FIFTH when 3 numbers match`() {
        assertThat(Rank.from(3, true)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH)
    }

    /**
     * Tests for Rank.from(matchCount < 3)
     * - Any result below 3 matches yields no rank
     * - Should return null
     */
    @Test
    fun `returns null when less than 3 numbers match`() {
        assertThat(Rank.from(2, true)).isNull()
        assertThat(Rank.from(2, false)).isNull()
        assertThat(Rank.from(1, true)).isNull()
        assertThat(Rank.from(1, false)).isNull()
        assertThat(Rank.from(0, true)).isNull()
        assertThat(Rank.from(0, false)).isNull()
    }
}
