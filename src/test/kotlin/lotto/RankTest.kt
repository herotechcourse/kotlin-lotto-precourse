package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RankTest {
    @Test
    fun `returns FIRST when 6 numbers match`() {
        assertThat(Rank.from(6, true)).isEqualTo(Rank.FIRST)
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND when 5 numbers match and bonus matches`() {
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD when 5 numbers match and bonus does not match`() {
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH when 4 numbers match`() {
        assertThat(Rank.from(4, true)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH when 3 numbers match`() {
        assertThat(Rank.from(3, true)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns null when less than 3 numbers match`() {
        assertThat(Rank.from(2, true)).isNull()
        assertThat(Rank.from(2, false)).isNull()
        assertThat(Rank.from(1, true)).isNull()
        assertThat(Rank.from(0, false)).isNull()
    }
}
