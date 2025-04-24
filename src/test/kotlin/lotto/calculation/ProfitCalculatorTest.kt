package lotto.calculation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `should calculate total return rate correctly based on provided data`() {

        val ticketCalculator = TicketCalculator()
        val profitCalculator = ProfitCalculator(ticketCalculator)

        // Prize Results
        val prizeResults = listOf(
            "Ticket [13, 14, 15, 16, 17, 18] - Prize: 3 Matches (5,000 KRW)"
        )

        // Purchase amount
        val purchaseAmount = 8000

        // Calculate the total return rate
        val returnRate = profitCalculator.calculateReturnRate(prizeResults, purchaseAmount)

        // Return rate = (5,000 / 8000) * 100 = 62.5%
        val expectedReturnRate = 62.5
        Assertions.assertEquals(expectedReturnRate, returnRate)
    }
}