package lotto.view

import lotto.Lotto
import lotto.Rank
import java.text.NumberFormat
import java.util.*

class LottoViewFormatter(
    private val numberFormatter: NumberFormat = NumberFormat.getNumberInstance(Locale.KOREA)
) {

    fun formatPurchaseMessage(lottoTickets: List<Lotto>) = "You have purchased ${lottoTickets.size} tickets."

    fun formatLottoTickets(lottoTickets: List<Lotto>): String = lottoTickets
        .map { it.getNumbers().sorted() }
        .joinToString(LN)

    fun formatWinningStatistics(rankCounts: Map<Rank, Int>): String = Rank.entries
        .filter { it != Rank.NONE }
        .sortedBy { it.prize }
        .joinToString(LN) { it.toStatisticsLine(rankCounts) }

    fun formatProfitRate(profitRate: Double): String {
        val formatted = PROFIT_RATE_FORMAT.format(profitRate)

        return "Total return rate is $formatted%."
    }

    private fun Rank.toStatisticsLine(rankCounts: Map<Rank, Int>): String {
        val count = rankCounts[this] ?: 0
        val formattedPrize = numberFormatter.format(this.prize.amount)
        val bonusInfo = if (this == Rank.SECOND) "+ Bonus Ball " else ""

        return "$matchCount Matches $bonusInfo(${formattedPrize} KRW) – $count tickets"
    }

    companion object {
        private const val PROFIT_RATE_FORMAT = "%.1f"
        private const val LN = "\n"
    }
}
