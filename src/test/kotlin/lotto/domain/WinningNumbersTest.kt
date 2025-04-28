package lotto.domain

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Nested
    inner class ValidationTest {
        @Test
        fun `throws an exception when lotto numbers exceed six`() {
            assertThrows<IllegalArgumentException> {
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
            }
        }

        @Test
        fun `throws an exception when lotto numbers are duplicated`() {
            assertThrows<IllegalArgumentException> {
                WinningNumbers(listOf(1, 2, 3, 4, 5, 5))
            }
        }
    }
}