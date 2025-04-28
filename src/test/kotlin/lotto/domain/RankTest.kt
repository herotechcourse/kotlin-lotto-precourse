package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `valueOf returns FIRST for 6 matches`() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `valueOf returns SECOND for 5 matches and bonus match`() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `valueOf returns THIRD for 5 matches without bonus`() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `valueOf returns FOURTH for 4 matches`() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `valueOf returns FIFTH for 3 matches`() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `valueOf returns MISS for 2 matches without bonus`() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.MISS)
    }

    @Test
    fun `valueOf returns MISS for 2 matches with bonus`() {
        assertThat(Rank.of(2, true)).isEqualTo(Rank.MISS)
    }
}