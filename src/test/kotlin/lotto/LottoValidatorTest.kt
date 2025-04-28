package lotto

import lotto.util.LottoValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoValidatorTest {
    @Test
    fun `throws exception for invalid amount`() {
        assertThrows<IllegalArgumentException> {
            LottoValidator.validateAmount(1500)
        }

        assertThrows<IllegalArgumentException> {
            LottoValidator.validateAmount(-1000)
        }
    }

    @Test
    fun `throws exception for invalid winning numbers`() {
        assertThrows<IllegalArgumentException> {
            LottoValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5)) // not 6 numbers
        }

        assertThrows<IllegalArgumentException> {
            LottoValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5)) // duplicate
        }

        assertThrows<IllegalArgumentException> {
            LottoValidator.validateWinningNumbers(listOf(0, 2, 3, 4, 5, 6)) // out of range
        }
    }

    @Test
    fun `throws exception for invalid bonus number`() {
        assertThrows<IllegalArgumentException> {
            LottoValidator.validateBonusNumber(46, listOf(1, 2, 3, 4, 5, 6))
        }

        assertThrows<IllegalArgumentException> {
            LottoValidator.validateBonusNumber(3, listOf(1, 2, 3, 4, 5, 6)) // duplicate
        }
    }
}
