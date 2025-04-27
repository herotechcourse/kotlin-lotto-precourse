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

    @Test
    fun `throws exception when winning numbers are empty`() {
        assertThrows<IllegalArgumentException> { validator.isWinningNumbersValid("  ") }
    }

    @Test
    fun `throws exception when winning numbers are not comma separated`() {
        assertThrows<IllegalArgumentException> { validator.isWinningNumbersValid("1,34567") }
    }

    @Test
    fun `throws exception when winning numbers are not integers`() {
        assertThrows<IllegalArgumentException> { validator.isWinningNumbersValid("1,3,4,abc,7,8") }
    }

    @Test
    fun `throws exception when the amount of winning numbers is not 6 `() {
        assertThrows<IllegalArgumentException> { validator.isWinningNumbersValid("1,2,3,4,5") }
    }

    @Test
    fun `throws exception when winning numbers are not in range from 1 to 45`() {
        assertThrows<IllegalArgumentException> { validator.isWinningNumbersValid("1,32,47,5,8,2") }
    }

    @Test
    fun `throws exception when winning numbers are not unique`() {
        assertThrows<IllegalArgumentException> { validator.isWinningNumbersValid("1,2,1,4,6,7") }
    }

    @Test
    fun `accepts winning numbers with extra spaces between commas`() {
        val result = validator.isWinningNumbersValid("1, 2, 5 ,  4  ,6 , 7 ")
        assertEquals(listOf(1,2,5,4,6,7), result) }

    @Test
    fun `returns list of winning numbers if input is valid`() {
        val result = validator.isWinningNumbersValid("1,2,5,4,6,7")
        assertEquals(listOf(1,2,5,4,6,7), result) }
}