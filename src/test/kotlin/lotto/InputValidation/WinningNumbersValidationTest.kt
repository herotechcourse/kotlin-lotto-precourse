package lotto.InputValidation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersValidationTest {
    private val validator = WinningNumbersValidation()

    @Test
    fun `exception winning numbers null exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.NullCheckWinningNumber("")
        }
        assertEquals("[ERROR] Winning numbers cannot be empty. Enter 6 unique numbers.", exception.message)
    }

    @Test
    fun `feature winning numbers split into list of integers test`() {
        val numbers = validator.SplitNumbersIntoList("1,2,3,4,5,6")

        assertEquals(numbers, listOf(1, 2, 3, 4, 5, 6))
    }
}