package lotto

import lotto.Application.Companion.Prize
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CashierTest {

    @Test
    fun `should calculate total return rate correctly`() {
        val cashier = Cashier(1000)
        val results = mapOf(
            Prize.MATCH_THREE to 2, // 2 tickets with 5,000 KRW each
            Prize.MATCH_FOUR to 1, // 1 ticket with 50,000 KRW
            Prize.MATCH_FIVE to 0,
            Prize.MATCH_FIVE_BONUS to 0,
            Prize.MATCH_SIX to 1 // 1 ticket with 2,000,000,000 KRW
        )
        val amountSpent = 5_000 // 5 tickets purchased at 1,000 KRW each

        val totalReturnRate = cashier.calculateTotalReturnRate(results, amountSpent)

        val expectedTotalPrize = (2 * 5_000) + (1 * 50_000) + (1 * 2_000_000_000)
        val expectedReturnRate = (expectedTotalPrize.toDouble() / amountSpent) * 100

        assertEquals(expectedReturnRate, totalReturnRate, 0.01)
    }

    @Test
    fun `should return zero return rate when no prizes are won`() {
        val cashier = Cashier(1000)
        val results = mapOf(
            Prize.MATCH_THREE to 0,
            Prize.MATCH_FOUR to 0,
            Prize.MATCH_FIVE to 0,
            Prize.MATCH_FIVE_BONUS to 0,
            Prize.MATCH_SIX to 0
        )
        val amountSpent = 10_000 // 10 tickets purchased at 1,000 KRW each

        val totalReturnRate = cashier.calculateTotalReturnRate(results, amountSpent)

        assertEquals(0.0, totalReturnRate)
    }

    @Test
    fun `should throw IllegalArgumentException when ticket price is zero`() {
        assertThrows<IllegalArgumentException> { Cashier(0) }
    }

    @Test
    fun `should calculate the correct number of tickets`() {
        val cashier = Cashier(1000)
        val result = cashier.calculateNumberOfTickets(5000)
        assertEquals(5, result)
    }

    @Test
    fun `should return zero tickets when amount is less than ticket price`() {
        val cashier = Cashier(1000)
        val result = cashier.calculateNumberOfTickets(500)
        assertEquals(0, result)
    }
}
