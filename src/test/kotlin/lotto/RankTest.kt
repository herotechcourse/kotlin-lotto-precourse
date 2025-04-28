package lotto

import lotto.domain.Rank
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RankTest {
    @Test
    fun `get rank for all tiers`() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.getRank(2, false)).isEqualTo(Rank.NON)
    }
}