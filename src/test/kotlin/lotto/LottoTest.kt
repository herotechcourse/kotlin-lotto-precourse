package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto number is out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `correctly counts matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getMatchCount(listOf(1, 2, 3, 7, 8, 9))).isEqualTo(3)
        assertThat(lotto.getMatchCount(listOf(7, 8, 9, 10, 11, 12))).isEqualTo(0)
        assertThat(lotto.getMatchCount(listOf(1, 2, 3, 4, 5, 6))).isEqualTo(6)
    }

    @Test
    fun `correctly identifies bonus number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.hasBonusNumber(7)).isFalse
        assertThat(lotto.hasBonusNumber(1)).isTrue
    }

    @Test
    fun `correctly determines rank`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getRank(listOf(1, 2, 3, 4, 5, 6), 7)).isEqualTo(LottoRank.FIRST)
        assertThat(lotto.getRank(listOf(1, 2, 3, 4, 5, 7), 6)).isEqualTo(LottoRank.SECOND)
        assertThat(lotto.getRank(listOf(1, 2, 3, 4, 5, 7), 8)).isEqualTo(LottoRank.THIRD)
        assertThat(lotto.getRank(listOf(1, 2, 3, 4, 7, 8), 9)).isEqualTo(LottoRank.FOURTH)
        assertThat(lotto.getRank(listOf(1, 2, 3, 7, 8, 9), 10)).isEqualTo(LottoRank.FIFTH)
        assertThat(lotto.getRank(listOf(7, 8, 9, 10, 11, 12), 13)).isEqualTo(LottoRank.NONE)
    }

    @Test
    fun `returns sorted numbers`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertThat(lotto.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}