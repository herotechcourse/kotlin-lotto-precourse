package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `throws an exception when bonus number is out of valid range`(input: Int) {
        assertThrows<IllegalArgumentException> {
            BonusNumber(input)
        }
    }

    @Test
    fun `throws an exception when bonus number is included in winning numbers`() {
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            BonusNumber.from("6", winningNumber)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "a"])
    fun `throws an exception when bonus number is not an integer`(input: String) {
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        assertThrows<IllegalArgumentException> {
            BonusNumber.from(input, winningNumber)
        }
    }

    @Test
    fun `creates BonusNumber successfully when valid and not duplicated`() {
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber.from("7", winningNumber)
        assertEquals(7, bonusNumber.getNumber())
    }
}
