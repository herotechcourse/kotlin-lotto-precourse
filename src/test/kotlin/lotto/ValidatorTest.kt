package lotto.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `purchase amount below minimum throws`() {
        assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseAmount(Rule.LOTTO_PRICE - 100)
        }
    }

    @Test
    fun `purchase amount not divisible throws`() {
        assertThrows<IllegalArgumentException> {
            Validator.validatePurchaseAmount(Rule.LOTTO_PRICE * 3 + 500)
        }
    }

    @Test
    fun `valid purchase amount does not throw`() {
        assertDoesNotThrow {
            Validator.validatePurchaseAmount(Rule.LOTTO_PRICE * 5)
        }
    }

    @Test
    fun `lotto numbers count incorrect throws`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateLottoNumbers(listOf(1, 2, 3, 4, 5))
        }
        assertThrows<IllegalArgumentException> {
            Validator.validateLottoNumbers((1..7).toList())
        }
    }

    @Test
    fun `lotto numbers out of range throws`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateLottoNumbers(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Validator.validateLottoNumbers(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `lotto numbers duplicates throws`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateLottoNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `valid lotto numbers does not throw`() {
        assertDoesNotThrow {
            Validator.validateLottoNumbers(listOf(3, 15, 22, 30, 41, 45))
        }
    }

    @Test
    fun `bonus number out of range throws`() {
        val winning = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber(0, winning)
        }
        assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber(46, winning)
        }
    }

    @Test
    fun `bonus number duplicates winning throws`() {
        val winning = listOf(10, 20, 30, 40, 41, 42)
        assertThrows<IllegalArgumentException> {
            Validator.validateBonusNumber(30, winning)
        }
    }

    @Test
    fun `valid bonus number does not throw`() {
        assertDoesNotThrow {
            Validator.validateBonusNumber(7, listOf(5, 12, 23, 34, 38, 41))
        }
    }
}