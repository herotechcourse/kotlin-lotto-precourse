package lotto.validator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    private val v = InputValidator()

    @Test
    fun `valid purchase amount returns int`() {
        assertEquals(14000, v.validatePurchaseAmount("14000"))
    }

    @Test
    fun `non-numeric purchase throws`() {
        assertThrows<IllegalArgumentException> {
            v.validatePurchaseAmount("abc")
        }
    }

    @Test
    fun `not divisible by 1000 throws`() {
        assertThrows<IllegalArgumentException>
        {
            v.validatePurchaseAmount("1500")
        }
    }

    @Test
    fun `valid winning numbers returns list`() {
        val list = v.validateWinningNumbers("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), list)
    }

    @Test
    fun `invalid format winning throws`() {
        assertThrows<IllegalArgumentException> {
            v.validateWinningNumbers("1,2,3,4,5")
        }
    }

    @Test
    fun `duplicate winning throws`() {
        assertThrows<IllegalArgumentException> {
            v.validateWinningNumbers("1,2,3,4,5,5")
        }
    }

    @Test
    fun `valid bonus returns int`() {
        assertEquals(7, v.validateBonusNumber("7"))
    }

    @Test
    fun `non-numeric bonus throws`() {
        assertThrows<IllegalArgumentException> {
            v.validateBonusNumber("seven")
        }
    }

    @Test
    fun `out-of-range bonus throws`() {
        assertThrows<IllegalArgumentException> {
            v.validateBonusNumber("50")
        }
    }
}
