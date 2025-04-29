package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `Rank correctly maps match count and bonus`() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE)
    }
}