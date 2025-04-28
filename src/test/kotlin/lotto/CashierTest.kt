package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CashierTest {

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
