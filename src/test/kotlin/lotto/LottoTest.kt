package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `correctly counts matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `correctly detects bonus number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.containsBonus(6)).isTrue
        assertThat(lotto.containsBonus(10)).isFalse
    }

    @Test
    fun `returns sorted lotto numbers`() {
        val lotto = Lotto(listOf(6, 2, 4, 1, 5, 3))
        assertThat(lotto.getSortedNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }
}
