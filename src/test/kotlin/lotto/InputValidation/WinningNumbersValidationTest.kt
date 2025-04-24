package lotto.InputValidation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersValidationTest {
    private val validator = WinningNumbersValidation()

    @Test
    fun `exception Winning numbers null exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.NullCheckWinningNumber("")
        }
        assertEquals("[ERROR] Winning numbers cannot be empty. Enter 6 unique numbers.", exception.message)
    }

    @Test
    fun `exception Winning numbers size should be 6 test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.SizeOfWinningNumberValidation(listOf(1,2,3,5,6))

        }
        assertEquals("[ERROR] Enter 6 unique numbers.", exception.message)
    }

    @Test
    fun `exception Winning numbers are in range of 1 and 45 test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.UniqueWinningNumbersValidation(listOf(1,2,3,5,6,1))

        }
        assertEquals("[ERROR] Enter unique numbers only.", exception.message)
    }
    @Test
    fun `exception Winning numbers are distinct and size should be 6 test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateWinningNumberInRange1to45(listOf(1,2,3,5,6,50))

        }
        assertEquals("[ERROR] Numbers must be between 1 and 45.", exception.message)
    }

    @Test
    fun `feature Winning numbers split into list of integers test`() {
        val numbers = validator.SplitNumbersIntoList("1,2,3,4,5,6")

        assertEquals(numbers,listOf(1,2,3,4,5,6))
    }


}