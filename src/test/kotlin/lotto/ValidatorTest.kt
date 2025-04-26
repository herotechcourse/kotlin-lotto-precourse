package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `throws exception when purchase amount is not integer or null`() {
        assertThrows<IllegalArgumentException> { validator.isPurchaseAmountValid("abc") }
    }

    @Test
    fun `throws exception when purchase amount is a negative number`() {
        assertThrows<IllegalArgumentException> { validator.isPurchaseAmountValid("-1000") }
    }

    @Test
    fun `throws exception when purchase amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> { validator.isPurchaseAmountValid("999") }
    }

    @Test
    fun `returns number when purchase amount is valid`() {
        val result = validator.isPurchaseAmountValid("8000")
        assertEquals(8000, result) }
}