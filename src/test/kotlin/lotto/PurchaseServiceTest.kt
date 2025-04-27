package lotto.lotto

import lotto.Lotto
import lotto.PurchaseService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseServiceTest {

    // Instance of the PurchaseService class to test its methods
    val purchaseService = PurchaseService()

    @Test
    fun `should return correct ticket count for valid purchase amount`() {
        // Arrange: Define a valid purchase amount
        val purchaseAmount = 8000

        // Act: Call the getTicketCount method with mocked user input
        val ticketCount = purchaseService.getTicketCount(purchaseAmount.toString())

        // Assert: Verify that the ticket count is calculated correctly
        Assertions.assertEquals(8, ticketCount, "Ticket count should match the purchase amount divided by 1000")
    }

    @Test
    fun `should throw exception for invalid purchase amount less than 1000`() {
        // Act & Assert: Validate that an exception is thrown for an amount less than 1000
        val exception = assertThrows<IllegalArgumentException> {
            purchaseService.validateAmount(500)
        }

        // Assert: Verify the exception message
        Assertions.assertEquals("Amount must be at least 1,000 KRW.", exception.message)
    }

    @Test
    fun `should throw exception for purchase amount not divisible by 1000`() {
        // Act & Assert: Validate that an exception is thrown for an amount not divisible by 1000
        val exception = assertThrows<IllegalArgumentException> {
            purchaseService.validateAmount(2500)
        }

        // Assert: Verify the exception message
        Assertions.assertEquals("Amount must be divisible by 1,000 KRW.", exception.message)
    }

    @Test
    fun `should print the correct number of tickets`() {
        // Arrange: Create a list of Lotto tickets
        val tickets = List(3) { Lotto(listOf(1, 2, 3, 4, 5, 6)) }

        // Act: Call the printTickets method to print the tickets
        purchaseService.printTickets(tickets)

        // Note: This test assumes that the print logic is correct and does not assert output
    }
}