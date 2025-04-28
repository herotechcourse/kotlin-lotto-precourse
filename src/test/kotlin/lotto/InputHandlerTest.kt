import lotto.InputHandler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputHandlerTest {

    private val inputHandler = InputHandler()

    @Test
    @DisplayName("When input is String, it must be parsed to Int")
    fun readPurchaseAmount_validInput() {
        val fakeInput = { "5000" }
        val result = inputHandler.readPurchaseAmount(fakeInput)
        assertEquals(5000, result)
    }

    @Test
    @DisplayName("When input is not a number, NumberFormatException should be thrown")
    fun readPurchaseAmount_nonNumericInput() {
        val fakeInput = { "abc" }
        val exception = assertThrows(NumberFormatException::class.java) {
            inputHandler.readPurchaseAmount(fakeInput)
        }
        assertEquals("For input string: \"abc\"", exception.message)
    }

    @Test
    @DisplayName("When input is negative, IllegalArgumentException should be thrown")
    fun readPurchaseAmount_negativeInput() {
        val fakeInput = { "-1000" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readPurchaseAmount(fakeInput)
        }
        assertEquals("[ERROR] Please re-enter a positive number.", exception.message)
    }

    @Test
    @DisplayName("When input is 0, IllegalArgumentException should be thrown")
    fun readPurchaseAmount_zeroInput() {
        val fakeInput = { "0" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readPurchaseAmount(fakeInput)
        }
        assertEquals("[ERROR] Please re-enter a positive number.", exception.message)
    }

    @Test
    @DisplayName("When input is not divisible by 1000, IllegalArgumentException should be thrown")
    fun readPurchaseAmount_notDivisibleByLottoPrice() {
        val fakeInput = { "1500" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readPurchaseAmount(fakeInput)
        }
        assertEquals("[ERROR] Input must be divided by lotto amount 1000.", exception.message)
    }

    @Test
    @DisplayName("When input is 6 valid numbers, it should return list of integers")
    fun readWinningNumbers_validInput() {
        val fakeInput = { "1,2,3,4,5,6" }
        val result = inputHandler.readWinningNumbers(fakeInput)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    @DisplayName("When input contains non-numeric value, NumberFormatException should be thrown")
    fun readWinningNumbers_nonNumericInput() {
        val fakeInput = { "1,2,three,4,5,6" }
        assertThrows(NumberFormatException::class.java) {
            inputHandler.readWinningNumbers(fakeInput)
        }
    }

    @Test
    @DisplayName("When input contains duplicated numbers, IllegalArgumentException should be thrown")
    fun readWinningNumbers_duplicateNumbers() {
        val fakeInput = { "1,2,3,4,5,5" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readWinningNumbers(fakeInput)
        }
        assertEquals("[ERROR] Please re-enter non duplicate numbers.", exception.message)
    }

    @Test
    @DisplayName("When input contains number out of range, IllegalArgumentException should be thrown")
    fun readWinningNumbers_outOfRangeNumbers() {
        val fakeInput = { "1,2,3,4,5,46" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readWinningNumbers(fakeInput)
        }
        assertEquals("[ERROR] Please re-enter number range in 1 to 45.", exception.message)
    }

    @Test
    @DisplayName("When input contains less than 6 numbers, IllegalArgumentException should be thrown")
    fun readWinningNumbers_lessThanSixNumbers() {
        val fakeInput = { "1,2,3,4,5" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readWinningNumbers(fakeInput)
        }
        assertEquals("[ERROR] Please re-enter 6 numbers.", exception.message)
    }

    @Test
    @DisplayName("When input contains more than 6 numbers, IllegalArgumentException should be thrown")
    fun readWinningNumbers_moreThanSixNumbers() {
        val fakeInput = { "1,2,3,4,5,6,7" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readWinningNumbers(fakeInput)
        }
        assertEquals("[ERROR] Please re-enter 6 numbers.", exception.message)
    }

}
