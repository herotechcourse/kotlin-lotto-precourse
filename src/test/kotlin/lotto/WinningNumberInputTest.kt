package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberInputTest {

    @Test
    fun `should return valid winning numbers`() {
        // Arrange
        val inputView = TestLottoInputView("1, 2, 3, 4, 5, 6")
        val winningNumberInput = WinningNumberInput(inputView)

        // Act
        val winningNumbers = winningNumberInput.getWinningNumbers()

        // Assert
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumbers)
    }

    @Test
    fun `should throw exception for invalid winning numbers input`() {
        // Arrange
        val inputView = TestLottoInputView("1, 2, invalid, 4, 5, 6")
        val winningNumberInput = WinningNumberInput(inputView)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            winningNumberInput.getWinningNumbers()
        }
        assertEquals("You must enter exactly 6 numbers.", exception.message)
    }

    @Test
    fun `should throw exception for duplicate winning numbers`() {
        // Arrange
        val inputView = TestLottoInputView("1, 2, 3, 3, 5, 6")
        val winningNumberInput = WinningNumberInput(inputView)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            winningNumberInput.getWinningNumbers()
        }
        assertEquals("Numbers must be unique.", exception.message)
    }

    @Test
    fun `should throw exception for winning numbers out of range`() {
        // Arrange
        val inputView = TestLottoInputView("1, 2, 3, 4, 5, 46")
        val winningNumberInput = WinningNumberInput(inputView)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            winningNumberInput.getWinningNumbers()
        }
        assertEquals("All numbers must be between 1 and 45.", exception.message)
    }

    @Test
    fun `should return valid bonus number`() {
        // Arrange
        val inputView = TestLottoInputView("7")
        val winningNumberInput = WinningNumberInput(inputView)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // Act
        val bonusNumber = winningNumberInput.getBonusNumber(winningNumbers)

        // Assert
        assertEquals(7, bonusNumber)
    }

    @Test
    fun `should throw exception for bonus number in winning numbers`() {
        // Arrange
        val inputView = TestLottoInputView("3")
        val winningNumberInput = WinningNumberInput(inputView)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            winningNumberInput.getBonusNumber(winningNumbers)
        }
        assertEquals("Bonus number must not be included in the winning numbers.", exception.message)
    }

    @Test
    fun `should throw exception for bonus number out of range`() {
        // Arrange
        val inputView = TestLottoInputView("46")
        val winningNumberInput = WinningNumberInput(inputView)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            winningNumberInput.getBonusNumber(winningNumbers)
        }
        assertEquals("Bonus number must be between 1 and 45.", exception.message)
    }

    // Test implementation of LottoInputView
    private class TestLottoInputView(private val input: String) : LottoInputView {
        override fun getPurchaseAmount(): String = ""
        override fun getWinningNumbersInput(): String = input
        override fun getBonusNumberInput(): String = input
    }
}