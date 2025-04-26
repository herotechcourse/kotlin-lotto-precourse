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
    fun `throws an exception when any lotto number is not between 1 and 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 0))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `gets a copy of lotto numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.getNumbers()).isEqualTo(numbers)
    }

    @Test
    fun `modifying the copied lotto numbers does not affect original numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)

        val copy = lotto.getNumbers().toMutableList()
        copy.add(7)

        assertThat(lotto.getNumbers()).hasSize(6)
        assertThat(lotto.getNumbers()).doesNotContain(7)
    }

    @Test
    fun `counts how many numbers matching between lotto and winning numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = listOf(3, 4, 5, 6, 7, 8)
        val lotto = Lotto(numbers)
        val winningLotto = Lotto(winningNumbers)

        val matchedNumbers = lotto.countMatches(winningLotto)
        assertThat(matchedNumbers).isEqualTo(4)
    }

    @Test
    fun `returns false when lotto does not contain the target number`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 10
        val lotto = Lotto(numbers)

        assertThat(lotto.containsNumber(bonusNumber)).isFalse()
    }

    @Test
    fun `returns true when lotto contains the target number`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 3
        val lotto = Lotto(numbers)

        assertThat(lotto.containsNumber(bonusNumber)).isTrue()
    }
}
