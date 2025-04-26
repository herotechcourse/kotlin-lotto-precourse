package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoRankTest {
    @Test
    fun `throws an exception when the count of matching number is lower than 0`() {
        assertThrows<IllegalArgumentException> {
            LottoRank.findByMatch(-1, true)
        }
    }

    @Test
    fun `throws an exception when the count of matching number is greater than 6`() {
        assertThrows<IllegalArgumentException> {
            LottoRank.findByMatch(-7, true)
        }
    }

    @Test
    fun `find correct ranks by provided match counts and bonus`() {
        assertThat(LottoRank.findByMatch(6, true)).isEqualTo(LottoRank.FIRST)
        assertThat(LottoRank.findByMatch(6, false)).isEqualTo(LottoRank.FIRST)

        assertThat(LottoRank.findByMatch(5, true)).isEqualTo(LottoRank.SECOND)

        assertThat(LottoRank.findByMatch(5, false)).isEqualTo(LottoRank.THIRD)

        assertThat(LottoRank.findByMatch(4, true)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.findByMatch(4, false)).isEqualTo(LottoRank.FOURTH)

        assertThat(LottoRank.findByMatch(3, true)).isEqualTo(LottoRank.FIFTH)
        assertThat(LottoRank.findByMatch(3, false)).isEqualTo(LottoRank.FIFTH)

        assertThat(LottoRank.findByMatch(2, true)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.findByMatch(2, false)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.findByMatch(1, true)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.findByMatch(1, false)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.findByMatch(0, true)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.findByMatch(0, false)).isEqualTo(LottoRank.NONE)
    }
}
