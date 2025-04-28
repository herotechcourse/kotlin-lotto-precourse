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

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `creates lotto instance successfully`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `contains returns true when number is in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val bonusNumber = 7

        assertThat(lotto.contains(bonusNumber)).isTrue()
    }

    @Test
    fun `countMatch returns correct number of matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)

        val matches = lotto.countMatch(winningNumbers)

        assertThat(matches).isEqualTo(3)
    }

    @Test
    fun `toString prints number in correct format`() {
        val lotto = Lotto(listOf(6, 2, 1, 4, 5, 3))
        val printLotto = lotto.toString()

        assertThat(printLotto).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }
}
