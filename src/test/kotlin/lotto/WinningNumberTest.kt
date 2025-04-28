package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,a", "1,2,3,4,5,", "1,2,3,4,5, "])
    fun `throws an exception when input string contains non-integer value`(input: String) {
        assertThrows<IllegalArgumentException> {
            WinningNumber.from(input)
        }
    }

    @Test
    fun `throws an exception when winning numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `throws an exception when winning number is out of valid range`(input: Int) {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(input, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `from creates WinningNumber from valid comma-separated string`() {
        val winningNumber = WinningNumber.from("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumber.getNumbers())
    }
}
