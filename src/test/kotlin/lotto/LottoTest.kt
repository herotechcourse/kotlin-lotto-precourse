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

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features
    @Test
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain a number out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `getNumbers should return correct list`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(numbers)
    }

    @Test
    fun `matchCount should return number of matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 3, 5, 7, 9, 11)
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `contains should return true if number is present`() {
        val lotto = Lotto(listOf(10, 11, 12, 13, 14, 15))
        assertThat(lotto.contains(12)).isTrue()
        assertThat(lotto.contains(20)).isFalse()
    }
}
