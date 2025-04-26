package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import camp.nextstep.edu.missionutils.Console
import lotto.view.InputView

class InputViewTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        Console.close()
    }

    @Test
    @DisplayName("readPurchaseAmount should correctly read and parse a valid integer input")
    fun readPurchaseAmount_WithValidInput_ReturnsInteger() {
        // given
        val input = "8000"
        System.setIn(ByteArrayInputStream(input.byteInputStream().readBytes()))

        // when
        val result = InputView.readPurchaseAmount()

        // then
        assertThat(result).isEqualTo(8000)
        assertThat(outputStreamCaptor.toString().trim()).contains("Please enter the purchase amount.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "123.45", "-100", "\n"])
    @DisplayName("readPurchaseAmount should throw an exception for invalid input")
    fun readPurchaseAmount_WithInvalidInput_ThrowsException(invalidInput: String) {
        // given
        System.setIn(ByteArrayInputStream(invalidInput.byteInputStream().readBytes()))

        // when & then
        assertThatThrownBy { InputView.readPurchaseAmount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Please enter a valid number.")
    }

    @Test
    @DisplayName("readWinningNumbers should correctly parse comma-separated integers")
    fun readWinningNumbers_WithValidInput_ReturnsListOfIntegers() {
        // given
        val input = "1,2,3,4,5,6"
        System.setIn(ByteArrayInputStream(input.byteInputStream().readBytes()))

        // when
        val result = InputView.readWinningNumbers()

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(outputStreamCaptor.toString().trim()).contains("Please enter last week's winning numbers.")
    }

    @Test
    @DisplayName("readWinningNumbers should handle spaces in the input")
    fun readWinningNumbers_WithSpaces_ReturnsListOfIntegers() {
        // given
        val input = "1, 2, 3, 4, 5, 6"
        System.setIn(ByteArrayInputStream(input.byteInputStream().readBytes()))

        // when
        val result = InputView.readWinningNumbers()

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,abc,5,6", "1,2,3,4.5,6", "\n"])
    @DisplayName("readWinningNumbers should throw an exception for invalid input")
    fun readWinningNumbers_WithInvalidInput_ThrowsException(invalidInput: String) {
        // given
        System.setIn(ByteArrayInputStream(invalidInput.byteInputStream().readBytes()))

        // when & then
        assertThatThrownBy { InputView.readWinningNumbers() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("readBonusNumber should correctly read and parse a valid integer input")
    fun readBonusNumber_WithValidInput_ReturnsInteger() {
        // given
        val input = "7"
        System.setIn(ByteArrayInputStream(input.byteInputStream().readBytes()))

        // when
        val result = InputView.readBonusNumber()

        // then
        assertThat(result).isEqualTo(7)
        assertThat(outputStreamCaptor.toString().trim()).contains("Please enter the bonus number.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "7.5", "-7", "\n"])
    @DisplayName("readBonusNumber should throw an exception for invalid input")
    fun readBonusNumber_WithInvalidInput_ThrowsException(invalidInput: String) {
        // given
        System.setIn(ByteArrayInputStream(invalidInput.byteInputStream().readBytes()))

        // when & then
        assertThatThrownBy { InputView.readBonusNumber() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Please enter a valid number.")
    }

    @Test
    @DisplayName("readWinningNumbers should throw exception with correct message for blank input")
    fun readWinningNumbers_WithBlankInput_ThrowsExceptionWithCorrectMessage() {
        // given
        val input = "\n"
        System.setIn(ByteArrayInputStream(input.byteInputStream().readBytes()))

        // when & then
        assertThatThrownBy { InputView.readWinningNumbers() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Please enter a valid number.")
    }

    @Test
    @DisplayName("readWinningNumbers should throw exception with correct message for non-numeric input")
    fun readWinningNumbers_WithNonNumericInput_ThrowsExceptionWithCorrectMessage() {
        // given
        val input = "1,2,3,abc,5,6"
        System.setIn(ByteArrayInputStream(input.byteInputStream().readBytes()))

        // when & then
        assertThatThrownBy { InputView.readWinningNumbers() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Please enter valid numbers separated by commas.")
    }

    @Test
    @DisplayName("readLineOrThrow should throw exception for blank input")
    fun readLineOrThrow_WithBlankInput_ThrowsException() {
        // This is testing a private method indirectly through public methods
        // given
        val input = "   "  // Only whitespace
        System.setIn(ByteArrayInputStream(input.byteInputStream().readBytes()))

        // when & then
        assertThatThrownBy { InputView.readPurchaseAmount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Please enter a valid number.")
    }
}