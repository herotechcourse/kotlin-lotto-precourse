package lotto

private const val PURCHASED_TICKETS_PREFIX = "\nYou have purchased "
private const val TICKET_UNIT = " tickets.\n"
private const val WINNING_STATISTICS_MESSAGE = "\nWinning Statistics\n---"
private const val TOTAL_RETURN_RATE_PREFIX = "Total return rate is "
private const val RETURN_RATE_UNIT = "%."

class OutputView {
    fun displayPurchasedTickets(lottoTickets: List<Lotto>) {
        println(PURCHASED_TICKETS_PREFIX + lottoTickets.size + TICKET_UNIT)
        lottoTickets.forEach { println(it.getSortedNumbers()) }
    }

    fun displayPrizeDistribution(prizeCountList: MutableMap<Prize, Int>) {
        println(WINNING_STATISTICS_MESSAGE)
        prizeCountList.forEach {
            println("${it.key.condition} (${it.key.getFormattedMoney()} KRW) – ${it.value} tickets")
        }
    }

    fun displayTotalReturnRate(returnRate: Double) {
        println(TOTAL_RETURN_RATE_PREFIX + returnRate + RETURN_RATE_UNIT)
    }
}