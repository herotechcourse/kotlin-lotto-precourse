package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TicketGeneratorTest : NsTest() {
    @Test
    fun `ticket has 6 unique numbers in range 1-45`() {
        val generator = TicketGenerator()
        val ticket = generator.generateTicket()
        assertAll(
            { assertEquals(6, ticket.size) },
            { assertEquals(6, ticket.distinct().size) },
            { assertTrue(ticket.all { it in 1..45 }) }
        )
    }

    @Test
    fun `assert that it generates correct number of tickets`() {
        val generator = TicketGenerator()
        val ticket = generator.generateMultiples(5)

        assertEquals(5, ticket.size)
    }

    @Test
    fun `assert that generated tickets are unique across multiple calls`() {
        val generator = TicketGenerator()
        val tickets = List(100) { generator.generateTicket().sorted() }
        val uniqueTickets = tickets.distinct()
        assertEquals(tickets.size, uniqueTickets.size)
    }

    override fun runMain() {
        main()
    }
}
