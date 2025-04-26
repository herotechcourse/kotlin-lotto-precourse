package lotto

import lotto.domain.LottoMatchResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `throws an exception with message when lotto numbers exceed required size`() {
        val numbers = (1..(Lotto.REQUIRED_SIZE + 1)).toList()
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
        assertThat(exception.message).isEqualTo(Lotto.ERROR_INVALID_SIZE)
    }

    @Test
    fun `throws an exception with message when lotto numbers are less than required size`() {
        val numbers = (1..(Lotto.REQUIRED_SIZE - 1)).toList()
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
        assertThat(exception.message).isEqualTo(Lotto.ERROR_INVALID_SIZE)
    }

    @Test
    fun `throws an exception with message when lotto numbers contain duplicates`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
        assertThat(exception.message).isEqualTo(Lotto.ERROR_DUPLICATE_NUMBERS)
    }

    @Test
    fun `throws an exception with message when lotto numbers are out of valid range`() {
        val invalidLow = listOf(0, 2, 3, 4, 5, 6)
        val exception1 = assertThrows<IllegalArgumentException> {
            Lotto(invalidLow)
        }
        assertThat(exception1.message).isEqualTo(Lotto.ERROR_OUT_OF_RANGE)

        val invalidHigh = listOf(1, 2, 3, 4, 5, Lotto.MAX_NUMBER + 1)
        val exception2 = assertThrows<IllegalArgumentException> {
            Lotto(invalidHigh)
        }
        assertThat(exception2.message).isEqualTo(Lotto.ERROR_OUT_OF_RANGE)
    }

    @Test
    fun `returns correct number of matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val matchCount = lotto.numberOfMatches(winningNumbers)

        assertThat(matchCount).isEqualTo(3)
    }

    @Test
    fun `returns true when bonus number is contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 7

        val containsBonus = lotto.containsBonus(bonusNumber)

        assertThat(containsBonus).isTrue()
    }

    @Test
    fun `returns false when bonus number is not contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonusNumber = 10

        val containsBonus = lotto.containsBonus(bonusNumber)

        assertThat(containsBonus).isFalse()
    }

    @Test
    fun `returns correct match result`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val matchResult: LottoMatchResult = lotto.toMatchResult(winningNumbers, bonusNumber)

        assertThat(matchResult.matchCount).isEqualTo(3)
        assertThat(matchResult.bonusMatched).isTrue()
    }
}
