package lotto.view

import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.PrizeRank

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println(getPurchaseMessage(tickets.size))
        tickets.forEach { println(it) }
    }

    fun printWinningStatistics(lottoResults: List<LottoResult>) {
        println(Constants.STATISTICS_HEADER)
        PrizeRank.entries
            .filter { it != PrizeRank.NONE }
            .sortedByDescending { it.matchCount }
            .forEach { println(getStatisticMessageFor(it, lottoResults))}
    }

    fun printReturnRate(returnRate: Double) {
        println(getReturnRateMessage(returnRate))
    }

    private fun getReturnRateMessage(returnRate: Double): String {
        return "Total return rate is $returnRate%."
    }

    private fun getPurchaseMessage(count: Int) = "You have purchased $count tickets"

    private fun getStatisticMessageFor(rank: PrizeRank, lottoResults: List<LottoResult>): String {
        val count = lottoResults.count { it.prizeRank == rank }
        val bonusMessage = if (rank.hasBonus) " + Bonus Ball" else ""
        val ticketsPluralization = if (count == 1) "ticket" else "tickets"

        return "${rank.matchCount} Matches$bonusMessage (${rank.prize} KRW) - ${count} $ticketsPluralization"
    }

    object Constants {
        const val STATISTICS_HEADER = "Winning Statistics\n---"
    }
}