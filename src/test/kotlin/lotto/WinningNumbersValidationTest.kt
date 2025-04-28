package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersValidationTest {

    @Test
    fun `valid winning numbers do not throw`() {
         validateWinning(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws when winning numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            validateWinning(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            validateWinning(listOf(1, 2, 2, 4, 5, 6))
        }
    }

    @Test
    fun `throws when winning numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            validateWinning(listOf(0, 2, 3, 4, 5, 6))
        }
    }
}
