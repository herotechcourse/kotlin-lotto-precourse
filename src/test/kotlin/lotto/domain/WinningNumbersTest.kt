package lotto.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class WinningNumbersTest {
    @Test
    fun `throws an exception when winning numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when winning numbers are duplicated`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("makeInvalidNumbers")
    @DisplayName("[Exception] throws when winning numbers are not between 1 and 45")
    fun `throws an exception when winning numbers are not valid range`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(numbers)
        }
    }

    companion object {
        @JvmStatic
        private fun makeInvalidNumbers(): List<List<Int>> {
            return listOf(
                listOf(1, 2, 3, 4, 5, 46),
                listOf(0, 20, 30, 40, 41, 42),
                listOf(-5, 15, 25, 35, 45, 1)
            )
        }
    }
}