package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PurchaseAmountTest {
    @Test
    fun `calculates correct ticket count`() {
        val purchaseAmount = PurchaseAmount("5000")
        val expectedTicketCount = 5
        assertEquals(expectedTicketCount, purchaseAmount.getTicketCount())
    }
}