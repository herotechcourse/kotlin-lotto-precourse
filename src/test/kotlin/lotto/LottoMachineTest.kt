package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

private const val PRICE_PER_TICKET = 1_000

class LottoMachineTest {

    private val testMachine = LottoMachine()

    @Test
    fun `issue bundle of lotto tickets based on the amount of input`() {
        val testCases = listOf(1000, 5000, 3000, 9000, 15000, 98000, 135000)
        testCases.forEach { case ->
            val tickets = testMachine.issueBundle(case)
            assertEquals(case / PRICE_PER_TICKET, tickets.size)
        }
    }

    @Test
    fun `each lotto tickets have 6 numbers`() {
        val testCases = listOf(1000, 5000, 3000)
        testCases.forEach { case ->
            val firstTicket = testMachine.issueBundle(case)[0]
            assertEquals(6, firstTicket.getNumbers().size)
        }
    }

    @Test
    fun `lotto tickets have non-duplicated numbers between 1 and 45`() {
        val testCases = listOf(1000, 2000, 7000)
        testCases.forEach { case ->
            val firstTicket = testMachine.issueBundle(case)[0]
            val numbers = firstTicket.getNumbers()
            assertTrue(numbers.all { it in 1..45 })
            assertEquals(6, numbers.distinct().size)
        }
    }

    @Test
    fun `numbers in lotto tickets are sorted in ascending order`() {
        val tickets = testMachine.issueBundle(25000)
        tickets.forEach { ticket ->
            val origin = ticket.getNumbers()
            val sorted = origin.sorted()
            assertEquals(sorted, origin)
        }
    }

    @Test
    fun `throws an exception when amount of currency is less than the price of a ticket`() {
        val testCases = listOf(0, -5, 1, 2, 9, 10, 100, 523, 999)
        testCases.forEach { case ->
            assertThrows<IllegalArgumentException> {
                testMachine.issueBundle(case)
            }
        }
    }

    @Test
    fun `throws an exception when amount of currency is indivisible by the price of a ticket`() {
        val testCases = listOf(1001, 1100, 1010, 1110, 1011, 4564, 9999, 1928376)
        testCases.forEach { case ->
            assertThrows<IllegalArgumentException> {
                testMachine.issueBundle(case)
            }
        }
    }
}