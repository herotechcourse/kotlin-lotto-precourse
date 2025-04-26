package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class ValidatorTest {
    /**
     * Tests for checkNumberFormat(input: String)
     * - Allows only numeric input
     * - Rejects alphabets, symbols, or mixed characters
     */
    @Test
    fun `throws an exception when input contains alphabet`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkNumberFormat("abc")
        }
    }

    @Test
    fun `throws an exception when input contains special characters`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkNumberFormat("123!")
        }
    }

    @Test
    fun `throws an exception when input contains alphanumeric mix`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkNumberFormat("1000j")
        }
    }

    @Test
    fun `does not throw when input is a valid number`() {
        assertDoesNotThrow {
            Validator.checkNumberFormat("123456")
        }
    }

    /**
     * Tests for checkNumbersFormat(input: String)
     * - Input must be comma-separated
     * - All segments must be numeric
     */
    @Test
    fun `throws an exception when input is not comma-separated`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkNumbersFormat("1 2 3")
        }
    }

    @Test
    fun `throws an exception when input contains non-numeric values`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkNumbersFormat("1,2,a")
        }
    }

    @Test
    fun `does not throw when input is valid comma-separated numbers`() {
        assertDoesNotThrow {
            Validator.checkNumbersFormat("1,2,3,4,5,6")
        }
    }

    /**
     * Tests for checkPurchaseAmountRules(value: Int)
     * - Must be greater than 0
     * - Must be a multiple of 1000
     */
    @Test
    fun `throws an exception when amount is zero`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkPurchaseAmountRules(0)
        }
    }

    @Test
    fun `throws an exception when amount is not a multiple of 1000`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkPurchaseAmountRules(2500)
        }
    }

    @Test
    fun `does not throw when amount is positive and a multiple of 1000`() {
        assertDoesNotThrow {
            Validator.checkPurchaseAmountRules(5000)
        }
    }

    /**
     * Tests for checkBonusNumberRules(value: Int, winningNumbers: List<Int>)
     * - Bonus number must not be included in winning numbers
     * - Bonus number must be in range 1 to 45
     */
    @Test
    fun `throws an exception when bonus number is included in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkBonusNumberRules(3, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when bonus number is out of valid range`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkBonusNumberRules(46, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `does not throw when bonus number is not in winning numbers and in valid range`() {
        assertDoesNotThrow {
            Validator.checkBonusNumberRules(7, listOf(1, 2, 3, 4, 5, 6))
        }
    }

    /**
     * Tests for checkLottoNumberRules(value: Int)
     * - Value must be between 1 and 45 (inclusive)
     */
    @Test
    fun `throws an exception when lotto number is zero`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkLottoNumberRules(0)
        }
    }

    @Test
    fun `throws an exception when lotto number is greater than 45`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkLottoNumberRules(46)
        }
    }

    @Test
    fun `does not throw when lotto number is within valid range`() {
        assertDoesNotThrow {
            Validator.checkLottoNumberRules(1)
            Validator.checkLottoNumberRules(45)
        }
    }

    /**
     * Tests for checkLottoNumbersRules(value: List<Int>)
     * - Must contain exactly 6 numbers
     * - All numbers must be unique
     * - Each number must be in range 1 to 45
     */
    @Test
    fun `throws an exception when lotto numbers list has less than 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkLottoNumbersRules(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers list contains duplicates`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkLottoNumbersRules(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers list contains number out of range`() {
        assertThrows<IllegalArgumentException> {
            Validator.checkLottoNumbersRules(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `does not throw when lotto numbers list is valid and unique`() {
        assertDoesNotThrow {
            Validator.checkLottoNumbersRules(listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
