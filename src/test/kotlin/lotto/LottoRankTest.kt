package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `should return FIRST rank for 6 matches`() {
        val rank = LottoRank.from(6, false)
        assertThat(rank).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `should return SECOND rank for 5 matches with bonus`() {
        val rank = LottoRank.from(5, true)
        assertThat(rank).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `should return THIRD rank for 5 matches without bonus`() {
        val rank = LottoRank.from(5, false)
        assertThat(rank).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `should format descriptions correctly`() {
        assertThat(LottoRank.FIRST.description).isEqualTo("6 Matches (2,000,000,000 KRW)")
        assertThat(LottoRank.SECOND.description).isEqualTo("5 Matches + Bonus Ball (30,000,000 KRW)")
    }
}