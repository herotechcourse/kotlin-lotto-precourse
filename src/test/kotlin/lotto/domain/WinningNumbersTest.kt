package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `throws an exception when winning number is empty string`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", ""))
        }
    }

    @Test
    fun `throws an exception when winning number is blank`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", "      "))
        }
    }

    @Test
    fun `throws an exception when winning number is not a number`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", "abc"))
        }
    }

    @Test
    fun `throws an exception when winning number is not positive number`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", "-1"))
        }
    }

    @Test
    fun `throws an exception when winning numbers are not 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5"))
        }

        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", "6", "7"))
        }
    }

    @Test
    fun `throws an exception when winning number is duplicated`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", "5"))
        }
    }

    @Test
    fun `throws an exception when winning numbers are not in range`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", "46"))
        }

        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("0", "2", "3", "4", "5", "5"))
        }
    }
}