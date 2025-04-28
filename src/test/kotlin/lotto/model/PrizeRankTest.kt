package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PrizeRankTest {
    @Test
    fun `gets correct prize rank based on match count and bonus`() {
        assertThat(PrizeRank.getRank(6, false)).isEqualTo(PrizeRank.FIRST)
        assertThat(PrizeRank.getRank(5, true)).isEqualTo(PrizeRank.SECOND)
        assertThat(PrizeRank.getRank(5, false)).isEqualTo(PrizeRank.THIRD)
        assertThat(PrizeRank.getRank(4, false)).isEqualTo(PrizeRank.FOURTH)
        assertThat(PrizeRank.getRank(3, false)).isEqualTo(PrizeRank.FIFTH)
        assertThat(PrizeRank.getRank(2, false)).isEqualTo(PrizeRank.NONE)
        assertThat(PrizeRank.getRank(1, false)).isEqualTo(PrizeRank.NONE)
        assertThat(PrizeRank.getRank(0, false)).isEqualTo(PrizeRank.NONE)
    }

}