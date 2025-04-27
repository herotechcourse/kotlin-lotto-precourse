package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseServiceTest {

    @Test
    fun `should return correct ticket count for valid purchase amount`() {
        // Arrange
        val inputView = TestLottoInputView("5000")
        val outputView = TestLottoOutputView()
        val purchaseService = PurchaseService(inputView, outputView)

        // Act
        val ticketCount = purchaseService.getTicketCount()

        // Assert
        assertEquals(5, ticketCount)
        assertEquals(5, outputView.ticketCount)
    }

    @Test
    fun `should throw exception for invalid input`() {
        // Arrange
        val inputView = TestLottoInputView("invalid")
        val outputView = TestLottoOutputView()
        val purchaseService = PurchaseService(inputView, outputView)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            purchaseService.getTicketCount()
        }
        assertEquals("Invalid input. Please enter a valid number.", exception.message)
    }

    @Test
    fun `should throw exception for amount less than 1000`() {
        // Arrange
        val inputView = TestLottoInputView("500")
        val outputView = TestLottoOutputView()
        val purchaseService = PurchaseService(inputView, outputView)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            purchaseService.getTicketCount()
        }
        assertEquals("Amount must be at least 1,000 KRW.", exception.message)
    }

    @Test
    fun `should throw exception for amount not divisible by 1000`() {
        // Arrange
        val inputView = TestLottoInputView("2500")
        val outputView = TestLottoOutputView()
        val purchaseService = PurchaseService(inputView, outputView)

        // Act & Assert
        val exception = assertThrows<IllegalArgumentException> {
            purchaseService.getTicketCount()
        }
        assertEquals("Amount must be divisible by 1,000 KRW.", exception.message)
    }

    // Test implementation of LottoInputView
    private class TestLottoInputView(private val input: String) : LottoInputView {
        override fun getPurchaseAmount(): String = input
        override fun getWinningNumbersInput(): String = ""
        override fun getBonusNumberInput(): String = ""
    }

    // Test implementation of LottoOutputView
    private class TestLottoOutputView : LottoOutputView {
        var ticketCount: Int? = null

        override fun showTicketCount(count: Int) {
            ticketCount = count
        }

        override fun showError(message: String) {
            // No-op for this test
        }

        override fun printTickets(tickets: List<Lotto>) {
            // No-op for this test
        }
    }
}