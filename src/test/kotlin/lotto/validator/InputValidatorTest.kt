package lotto.validator

import lotto.Lotto
import lotto.constants.Constants
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

object InputValidatorTest {
    @Test
    fun `success - notEmpty`() {
        assertDoesNotThrow {
            InputValidator.notEmpty("123")
        }
        assertDoesNotThrow {
            InputValidator.notEmpty("abc")
        }
        assertDoesNotThrow {
            InputValidator.notEmpty("hello")
        }
    }

    @Test
    fun `exception - notEmpty`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.notEmpty("")
        }
    }

    @Test
    fun `success - onlyContainsDigits`() {
        assertDoesNotThrow {
            InputValidator.onlyContainsDigits("0")
        }
        assertDoesNotThrow {
            InputValidator.onlyContainsDigits("12345")
        }
        assertDoesNotThrow {
            InputValidator.onlyContainsDigits(Int.MAX_VALUE.toString())
        }
    }

    @Test
    fun `exception - onlyContainsDigits`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.onlyContainsDigits("12a45")
        }
        assertThrows<IllegalArgumentException> {
            InputValidator.onlyContainsDigits("3.14")
        }
        assertThrows<IllegalArgumentException> {
            InputValidator.onlyContainsDigits("-123")
        }
    }

    @Test
    fun `success - withinPurchaseRange`() {
        assertDoesNotThrow {
            InputValidator.withinPurchaseRange(Constants.MIN_PURCHASE_RANGE)
        }
        assertDoesNotThrow {
            InputValidator.withinPurchaseRange(Constants.MAX_PURCHASE_RANGE)
        }
    }

    @Test
    fun `exception - withinPurchaseRange`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.withinPurchaseRange(Constants.MIN_PURCHASE_RANGE - 1)
        }
        assertThrows<IllegalArgumentException> {
            InputValidator.withinPurchaseRange(Constants.MAX_PURCHASE_RANGE + 1)
        }
    }

    @Test
    fun `success - isMultipleOfThousand`() {
        assertDoesNotThrow {
            InputValidator.isMultipleOfThousand(4000)
        }
        assertDoesNotThrow {
            InputValidator.isMultipleOfThousand(29000)
        }
    }

    @Test
    fun `exception - isMultipleOfThousand`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.isMultipleOfThousand(5500)
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.isMultipleOfThousand(12300)
        }
    }

    @Test
    fun `success - allAreDigits`() {
        assertDoesNotThrow {
            InputValidator.allAreDigits(listOf("1", "23", "456", "78910", "111213"))
        }

        assertDoesNotThrow {
            InputValidator.allAreDigits(listOf("1024"))
        }
    }

    @Test
    fun `exception - allAreNumber`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.allAreDigits(listOf("1", "two", "3"))
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.allAreDigits(listOf("1", "2", "-3", "4"))
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.allAreDigits(listOf("1", "1.2", "3", "4"))
        }
    }

    @Test
    fun `success - checkLottoSize`() {
        assertDoesNotThrow {
            InputValidator.checkLottoSize(listOf(1, 2, 3, 4, 5, 6))
        }

        assertDoesNotThrow {
            InputValidator.checkLottoSize(listOf(10, 20, 30, 40, 50, 60))
        }
    }

    @Test
    fun `exception - checkLottoSize`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkLottoSize(listOf(1, 2, 3, 4, 5, 6, 7))
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.checkLottoSize(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `success - numberIsRange`() {
        assertDoesNotThrow {
            InputValidator.numberIsRange(Constants.LOTTO_MIN_NUMBER)
        }

        assertDoesNotThrow {
            InputValidator.numberIsRange(Constants.LOTTO_MAX_NUMBER)
        }
    }

    @Test
    fun `exception - numberIsRange`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.numberIsRange(Constants.LOTTO_MIN_NUMBER - 1)
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.numberIsRange(Constants.LOTTO_MAX_NUMBER + 1)
        }
    }

    @Test
    fun `success - allNumbersInRange`() {
        assertDoesNotThrow {
            InputValidator.allNumbersInRange(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `exception - allNumbersInRange`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.allNumbersInRange(listOf(1, 2, 3, 4, 5, 6, Constants.LOTTO_MAX_NUMBER + 1))
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.allNumbersInRange(listOf(1, 2, 3, 4, 5, 6, Constants.LOTTO_MIN_NUMBER - 1))
        }
    }

    @Test
    fun `success - noDuplicateNumbers - success`() {
        assertDoesNotThrow {
            InputValidator.noDuplicateNumbers(listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `exception - noDuplicateNumbers`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.noDuplicateNumbers(listOf(1, 2, 3, 3, 5, 6))
        }
    }

    @Test
    fun `success - noDuplicateBonusNumber`() {
        val mainLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertDoesNotThrow {
            InputValidator.noDuplicateBonusNumber(7, mainLotto)
        }
    }

    @Test
    fun `exception - noDuplicateBonusNumber`() {
        val mainLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            InputValidator.noDuplicateBonusNumber(3, mainLotto)
        }
    }
}