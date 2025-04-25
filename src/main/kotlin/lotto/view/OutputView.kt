package lotto.view

import lotto.LottoTickets
import lotto.Rank

class OutputView(private val formatter: LottoViewFormatter) {

    fun printLottoTickets(lottoTickets: LottoTickets) {
        print(buildLottoTickets(lottoTickets))
    }

    fun printFinalReport(rankCounts: Map<Rank, Int>, profitRate: Double) {
        println(buildFinalReport(rankCounts, profitRate))
    }

    private fun buildLottoTickets(lottoTickets: LottoTickets): String = buildString {
        appendLine()
        appendLine(formatter.formatPurchaseMessage(lottoTickets))
        appendLine(formatter.formatLottoTickets(lottoTickets))
    }

    private fun buildFinalReport(rankCounts: Map<Rank, Int>, profitRate: Double): String = buildString {
        appendLine()
        appendLine("Winning Statistics")
        appendLine("---")
        appendLine(formatter.formatWinningStatistics(rankCounts))
        appendLine(formatter.formatProfitRate(profitRate))
    }

}
