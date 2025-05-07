package lotto

class OutputView {
    fun displayPurchasedTickets(lottoTickets: List<Lotto>) {
        println(Messages.PURCHASED_TICKETS_PREFIX + lottoTickets.size + TICKET_UNIT)
        lottoTickets.forEach { println(it.getSortedNumbers()) }
    }

    fun displayPrizeDistribution(prizeCountList: MutableMap<Prize, Int>) {
        println(Messages.WINNING_STATISTICS)
        prizeCountList.forEach {
            println("${it.key.condition} (${it.key.getFormattedMoney()} KRW) – ${it.value} tickets")
        }
    }

    fun displayTotalReturnRate(returnRate: Double) {
        println(Messages.TOTAL_RETURN_RATE_PREFIX + returnRate + Messages.RETURN_RATE_UNIT)
    }

    companion object Messages {
        const val PURCHASED_TICKETS_PREFIX = "\nYou have purchased "
        const val TICKET_UNIT = " tickets.\n"
        const val WINNING_STATISTICS = "\nWinning Statistics\n---"
        const val TOTAL_RETURN_RATE_PREFIX = "Total return rate is "
        const val RETURN_RATE_UNIT = "%."
    }
}