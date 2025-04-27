package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoRankTest {
    @Test
    fun `calculates FIRST rank correctly`() {
        val rank = LottoRank.calculateRank(6, false)
        assertThat(rank).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `calculates SECOND rank correctly`() {
        val rank = LottoRank.calculateRank(5, true)
        assertThat(rank).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `calculates THIRD rank correctly`() {
        val rank = LottoRank.calculateRank(5, false)
        assertThat(rank).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `calculates FOURTH rank correctly`() {
        val rank = LottoRank.calculateRank(4, false)
        assertThat(rank).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `calculates FIFTH rank correctly`() {
        val rank = LottoRank.calculateRank(3, false)
        assertThat(rank).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    fun `calculates NONE rank correctly for less than 3 matches`() {
        assertThat(LottoRank.calculateRank(2, false)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.calculateRank(1, false)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.calculateRank(0, false)).isEqualTo(LottoRank.NONE)
    }

    @Test
    fun `bonus number does not affect rank except for SECOND rank`() {
        assertThat(LottoRank.calculateRank(6, true)).isEqualTo(LottoRank.FIRST)
        assertThat(LottoRank.calculateRank(4, true)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.calculateRank(3, true)).isEqualTo(LottoRank.FIFTH)
        assertThat(LottoRank.calculateRank(2, true)).isEqualTo(LottoRank.NONE)
    }
}