package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    private val lotto = Lotto(listOf(1, 2, 3, 4,5,6))
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are out of 1-45 range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 75))
        }
    }

    @Test
    fun `number of lotto tickets generated based on the amount purchased`() {
        val numberOfTickets = lotto.CalculateNumberOfTickets(5000)
        assertEquals(5, numberOfTickets)
    }

    @Test
    fun `lotto tickets does not contain duplicate numbers`() {
        val tickets = lotto.GenerateLottoTickets(5)

        tickets.forEach { ticket ->
            assertTrue(
                ticket.distinct().size == ticket.size,
                "Ticket $ticket contains duplicate numbers."
            )
        }
    }
}
