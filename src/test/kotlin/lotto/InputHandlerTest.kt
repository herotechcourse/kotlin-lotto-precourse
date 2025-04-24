import lotto.InputHandler
import org.junit.jupiter.api.Assertions.*
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
        assertEquals("Please enter a positive number.", exception.message)
    }

    @Test
    @DisplayName("When input is 0, IllegalArgumentException should be thrown")
    fun readPurchaseAmount_zeroInput() {
        val fakeInput = { "0" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readPurchaseAmount(fakeInput)
        }
        assertEquals("Please enter a positive number.", exception.message)
    }

    @Test
    @DisplayName("When input is not divisible by 1000, IllegalArgumentException should be thrown")
    fun readPurchaseAmount_notDivisibleByLottoPrice() {
        val fakeInput = { "1500" }
        val exception = assertThrows(IllegalArgumentException::class.java) {
            inputHandler.readPurchaseAmount(fakeInput)
        }
        assertEquals("Input must be divided by lotto amount 1000", exception.message)
    }
}
