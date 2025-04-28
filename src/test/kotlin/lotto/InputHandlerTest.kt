package lotto

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.assertThat

class InputHandlerTest {
    private val inputHandler = InputHandler()
    private val originalIn = System.`in`
    private val originalOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
        System.setOut(originalOut)
        Console.close()
    }

    private fun provideInput(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }

    @Test
    fun `getPurchaseAmount should return valid amount`() {
        provideInput("8000\n")
        val amount = inputHandler.getPurchaseAmount()
        assertThat(amount).isEqualTo(8000)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000j", "abc", " "])
    fun `getPurchaseAmount should handle invalid number format`(input: String) {
        provideInput("$input\n8000\n")
        inputHandler.getPurchaseAmount()
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Please enter a valid number.")
    }

    @Test
    fun `getPurchaseAmount should handle amount less than minimum`() {
        provideInput("500\n1000\n")
        inputHandler.getPurchaseAmount()
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Purchase amount must be at least 1000KRW.")
    }

    @Test
    fun `getPurchaseAmount should handle amount not divisible by 1000`() {
        provideInput("1500\n2000\n")
        inputHandler.getPurchaseAmount()
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Purchase amount must be divisible by 1000.")
    }

    @Test
    fun `getWinningNumbers should return valid numbers`() {
        provideInput("1,2,3,4,5,6\n")
        val numbers = inputHandler.getWinningNumbers()
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `getWinningNumbers should handle duplicate numbers`() {
        provideInput("1,2,3,4,5,5\n1,2,3,4,5,6\n")
        inputHandler.getWinningNumbers()
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Please enter exactly 6 unique numbers.")
    }

    @Test
    fun `getWinningNumbers should handle invalid count`() {
        provideInput("1,2,3,4,5\n1,2,3,4,5,6\n")
        inputHandler.getWinningNumbers()
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Please enter exactly 6 unique numbers.")
    }

    @Test
    fun `getWinningNumbers should handle out of range numbers`() {
        provideInput("0,1,2,3,4,5\n1,2,3,4,5,6\n")
        inputHandler.getWinningNumbers()
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    @Test
    fun `getBonusNumber should return valid number`() {
        provideInput("7\n")
        val bonus = inputHandler.getBonusNumber(listOf(1, 2, 3, 4, 5, 6))
        assertThat(bonus).isEqualTo(7)
    }

    @Test
    fun `getBonusNumber should handle duplicate with winning numbers`() {
        provideInput("6\n7\n")
        inputHandler.getBonusNumber(listOf(1, 2, 3, 4, 5, 6))
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Bonus number must not duplicate winning numbers.")
    }

    @Test
    fun `getBonusNumber should handle out of range number`() {
        provideInput("46\n7\n")
        inputHandler.getBonusNumber(listOf(1, 2, 3, 4, 5, 6))
        assertThat(outputStreamCaptor.toString()).contains("[ERROR] Bonus number must be between 1 and 45.")
    }
}