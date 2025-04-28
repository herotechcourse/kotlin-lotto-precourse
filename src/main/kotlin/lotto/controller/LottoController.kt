package lotto.controller

import lotto.Lotto
import lotto.domain.TicketIssuer
import lotto.view.InputReader
import lotto.view.OutputPrinter

class LottoController(
    private val reader: InputReader,
    private val printer: OutputPrinter,
    private val issuer: TicketIssuer = TicketIssuer()
) {

    fun run(): Unit {
        // 1. Input purchase amount for buy the lottery tickets.
        val amount = reader.readPurchaseAmount()

        // 2. Print purchased lottery tickets with issued numbers (sorted)
        val ticketCount = amount.toInt() / Lotto.PRICE
        val tickets = issuer.issue(ticketCount)
        printer.printPurchasedTickets(tickets)

        // 3. Input last week's numbers
        // 4. Input a bonus number.
        // 5. Print lotto result statistics.
        // 6. Print calculated Profit rate.this.
        printer.close()

    }

    companion object {
        private const val TICKET_PRICE: Int = Lotto.PRICE
    }
}
