package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `returns correct amount for valid input`() {
        val result = InputValidator.validateAmount("5000")
        assertThat(result).isEqualTo(5000)
    }

    @Test
    fun `throws exception for non-integer input`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateAmount("5000j")
        }
    }

    @Test
    fun `throws exception for non-divisible amount`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateAmount("5500")
        }
    }

    @Test
    fun `returns parsed numbers for valid input`() {
        val result = InputValidator.validateWinningNumbers("1,2,3,4,5,6")
        assertThat(result).containsExactly(1,2,3,4,5,6)
    }

    @Test
    fun `throws exception for duplicate numbers`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1,2,3,4,5,5")
        }
    }

    @Test
    fun `throws exception for wrong number of inputs`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1,2,3,4,5")
        }
    }

    @Test
    fun `throws exception for numbers out of range`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("0,2,3,4,5,6")
        }
    }

    @Test
    fun `returns bonus number for valid input`() {
        val result = InputValidator.validateBonusNumber("7", listOf(1,2,3,4,5,6))
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun ` throws exception when input is non-integer`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("6a", listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `throws exception when bonus is out of range`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("46", listOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `throws exception when bonus overlaps with winning numbers`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("6", listOf(1,2,3,4,5,6))
        }
    }
}