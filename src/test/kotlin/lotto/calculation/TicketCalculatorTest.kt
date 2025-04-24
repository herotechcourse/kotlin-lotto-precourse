package lotto.calculation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TicketCalculatorTest {

    private val ticketCalculator = TicketCalculator()

    @Test
    fun `calculates the number of tickets correctly`() {
        val purchaseAmount = 5000
        val numberOfTickets = ticketCalculator.calculateNumberOfTickets(purchaseAmount)

        assertEquals(5, numberOfTickets, "The number of tickets should be 5 for purchase amount of 5000.")
    }
}