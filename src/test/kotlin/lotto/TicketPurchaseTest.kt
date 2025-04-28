package lotto

import lotto.constants.TICKET_COST
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class TicketPurchaseTest {
    private lateinit var ticketPurchase: TicketPurchase
    private lateinit var userInput: UserInput

    @BeforeEach
    fun setUp() {
        ticketPurchase = TicketPurchase()
        userInput = UserInput()
    }

    @Test
    fun `buyTickets should calculate amountOfTicketsBought correctly`() {
        val purchaseAmount = (TICKET_COST * 14).toString()
        userInput.setPurchaseAmount(purchaseAmount)

        ticketPurchase.buyTickets(userInput)

        assertThat(ticketPurchase.amountOfTicketsBought).isEqualTo(14)
    }

    @Test
    fun `generateTickets should create the correct number of tickets`() {
        val purchaseAmount = (TICKET_COST * 3).toString()
        userInput.setPurchaseAmount(purchaseAmount)
        ticketPurchase.buyTickets(userInput)

        ticketPurchase.generateTickets()

        assertThat(ticketPurchase.tickets).hasSize(3)
    }

    @Test
    fun `generateTickets should generate tickets with 6 unique numbers each`() {
        val purchaseAmount = (TICKET_COST * 3).toString()
        userInput.setPurchaseAmount(purchaseAmount)
        ticketPurchase.buyTickets(userInput)

        ticketPurchase.generateTickets()

        ticketPurchase.tickets.forEach { lotto ->
            assertThat(lotto.getNumbers())
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allSatisfy { number ->
                    assertThat(number).isBetween(1, 45)
                }
        }
    }
}