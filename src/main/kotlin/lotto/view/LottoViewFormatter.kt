package lotto.view

import lotto.Lotto
import java.text.NumberFormat
import java.util.*

class LottoViewFormatter(
    private val numberFormatter: NumberFormat = NumberFormat.getNumberInstance(Locale.KOREA)
) {

    fun formatPurchaseMessage(lottoTickets: List<Lotto>) = "You have purchased ${lottoTickets.size} tickets."

    fun formatLottoTickets(lottoTickets: List<Lotto>): String = lottoTickets
        .map { it.getNumbers().sorted() }
        .joinToString(LN)

    fun formatWinningStatistics(rankCounts: List<CountRankResponse>): String = rankCounts
        .sortedBy { it.matchCount }
        .joinToString(LN) { it.toStatisticsLine() }

    fun formatProfitRate(profitRate: Double): String {
        val formatted = PROFIT_RATE_FORMAT.format(profitRate)

        return "Total return rate is $formatted%."
    }

    private fun CountRankResponse.toStatisticsLine(): String {
        val formattedPrize = numberFormatter.format(this.prize)
        val bonusInfo = if (bonusMatch) "+ Bonus Ball " else ""

        return "$matchCount Matches $bonusInfo(${formattedPrize} KRW) – $count tickets"
    }

    companion object {
        private const val PROFIT_RATE_FORMAT = "%.1f"
        private const val LN = "\n"
    }
}
