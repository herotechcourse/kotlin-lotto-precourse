package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `throws an exception when winning numbers is empty string`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", ""))
        }
    }

    @Test
    fun `throws an exception when winning numbers is blank`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf("1", "2", "3", "4", "5", "      "))
        }
    }
}