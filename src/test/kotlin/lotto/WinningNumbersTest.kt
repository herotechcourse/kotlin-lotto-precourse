package lotto

import lotto.domain.WinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `throws an exception when winning numbers are not six`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 5), 7)
        }
    }

    @Test
    fun `throws an exception when winning number is out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 46), 7)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `throws an exception when bonus number is included in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }
}