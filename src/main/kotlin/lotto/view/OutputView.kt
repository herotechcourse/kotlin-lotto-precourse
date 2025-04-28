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
            .forEach { println(getStatisticMessageFor(it, lottoResults)) }
    }

    fun printReturnRate(returnRate: Double) {
        println(getReturnRateMessage(returnRate))
    }

    private fun pluralizeTicket(count: Int): String {
        val ending = if (count == 1) "" else "s"
        return "ticket$ending"
    }

    private fun getReturnRateMessage(returnRate: Double): String {
        return "Total return rate is $returnRate%."
    }

    private fun getPurchaseMessage(count: Int) = "You have purchased $count ${pluralizeTicket(count)}"

    private fun formatPrize(prize: Int): String {
        return prize.toString()
            .reversed()
            .replace("([0-9]{3})(?=[0-9])".toRegex(), "$1,")
            .reversed()
    }

    private fun getStatisticMessageFor(rank: PrizeRank, lottoResults: List<LottoResult>): String {
        val count = lottoResults.count { it.prizeRank == rank }
        val bonusMessage = if (rank.hasBonus) " + Bonus Ball" else ""

        return "${rank.matchCount} Matches$bonusMessage (${formatPrize(rank.prize)} KRW) - $count ${
            pluralizeTicket(
                count
            )
        }"
    }

    object Constants {
        const val STATISTICS_HEADER = "Winning Statistics\n---"
    }
}