package lotto

class OutputView {
    fun displayPurchasedTickets(lottoTickets: List<Lotto>) {
        print(Messages.PURCHASED_TICKETS_PREFIX)
        print(lottoTickets.size)
        print(TICKET_UNIT)
        lottoTickets.forEach { println(it.numberList) }
    }

    companion object Messages {
        const val PURCHASED_TICKETS_PREFIX = "/nYou have purchased "
        const val TICKET_UNIT = " tickets/n"
        const val WINNING_STATISTICS = "Winning Statistics\n---"
        const val TOTAL_RETURN_RATE_PREFIX = "Total return rate is "
    }
}