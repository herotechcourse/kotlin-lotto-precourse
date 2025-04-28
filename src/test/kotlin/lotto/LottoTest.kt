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
    fun `throws an exception when lotto numbers is not in the range 1-45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 55))
        }
    }

    @Test
    fun `should return the ticket numbers`() {
        val lotto = Lotto(listOf(1, 2, 4, 5, 8, 9))
        lotto.getNumbers()
        assertThat(listOf(1, 2, 4, 5, 8, 9)).isEqualTo(lotto.getNumbers())
    }

    @Test
    fun `should calculate matches in numbers and winning numbers`() {
        val lotto = Lotto(listOf(7, 12, 24, 35, 38, 41))
        val winningNumbers = listOf(1, 12, 15, 21, 35, 38)
        val matches = lotto.calculateMatches(winningNumbers)
        assertThat(3).isEqualTo(matches)
    }

    @Test
    fun `should find a bonus number`() {
        val lotto = Lotto(listOf(5, 13, 29, 31, 34, 42))
        val bonusNumber = 5
        val findBonusNumber = lotto.hasBonusNumber(bonusNumber)
        assertThat(findBonusNumber).isEqualTo(true)
    }
}
