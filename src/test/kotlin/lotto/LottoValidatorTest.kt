package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoValidatorTest {
    private val validator = LottoValidator()

    @Test
    fun `throws an exception when purchase amount is not numeric`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount("abc")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not positive`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount("0")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount("1500")
        }
    }

    @Test
    fun `throws an exception when winning numbers are not all numeric`() {
        assertThrows<IllegalArgumentException> {
            validator.validateWinningNumbers(listOf("1", "2", "a", "4", "5", "6"))
        }
    }

    @Test
    fun `throws an exception when bonus number is not numeric`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("abc", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("46", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }

    @Test
    fun `throws an exception when bonus number is duplicate of winning numbers`() {
        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("1", Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }
    }
}