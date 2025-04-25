package lotto.utilsTest

import lotto.utils.InputView
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * TODO: Decide whether tests for the methods `readInput` and `readLineSafe` are necessary.
 *  They require mocking the console like in the racingcar project and
 *  are therefore not small-scale tests as explained in feedback on pre-course week 1.
 *  Alternatively test them manually and mark them as tested in a comment and/or the readme.
 */

class InputViewTest {
    @Test
    fun `validateInputNotEmpty returns input if it is valid`() {
        val input = "42"
        val result = InputView.validateInputNotEmpty(input)
        assertThat(result).isEqualTo(input)
    }

    @Test
    fun `validateInputNotEmpty throws exception when input is null`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateInputNotEmpty(null)
        }
    }

    @Test
    fun `validateInputNotEmpty throws exception when input is empty`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateInputNotEmpty("")
        }
    }

    @Test
    fun `validateInputNotEmpty throws exception when input is blank`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateInputNotEmpty("   ")
        }
    }

    @Test
    fun `toUIntSafe converts valid string to UInt`() {
        val result = InputView.toUIntSafe("42")
        assertThat(result).isEqualTo(42u)
    }

    @Test
    fun `toUIntSafe throws exception for negative numbers`() {
        assertThrows<IllegalArgumentException> {
            InputView.toUIntSafe("-10")
        }
    }

    @Test
    fun `toUIntSafe throws exception for non-numeric input`() {
        assertThrows<IllegalArgumentException> {
            InputView.toUIntSafe("abc")
        }
    }

    @Test
    fun `validatePurchaseAmount throws exception when amount is zero`() {
        assertThrows<IllegalArgumentException> {
            InputView.validatePurchaseAmount(0u)
        }
    }

    @Test
    fun `validatePurchaseAmount throws exception when amount is not a multiple of 1000`() {
        assertThrows<IllegalArgumentException> {
            InputView.validatePurchaseAmount(1500u)
        }
    }

    @Test
    fun `validatePurchaseAmount does not throw exception for valid amounts`() {
        InputView.validatePurchaseAmount(3000u)
    }

    @Test
    fun `toWinningNumbers converts valid comma-separated numbers to UBytes`() {
        val input = "1,2,3,4,5,6"
        val result = InputView.toWinningNumbers(input)
        val expected = listOf(1, 2, 3, 4, 5, 6).map { it.toUByte() }
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 ,2,3,4,5,6", "a,2,3,4,5,6", "1,2,3,4,5,abc", "-1,2,3,4,5,6", "256,2,3,4,5,6"])
    fun `toWinningNumbers throws exception for invalid number input`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            InputView.toWinningNumbers(input)
        }
        assertEquals("[ERROR] Invalid input for winning numbers.", exception.message)
    }

}
