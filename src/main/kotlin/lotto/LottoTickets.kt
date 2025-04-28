package lotto

class LottoTickets(val tickets: List<LottoTicket>) {

    companion object {
        private const val TICKET_PRICE = 1000

        fun generate(purchaseAmount: Int): LottoTickets {
            val ticketCount = purchaseAmount / TICKET_PRICE
            val tickets = List(ticketCount) { LottoTicket.generate() }
            return LottoTickets(tickets)
        }
    }
}
