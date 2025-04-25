package lotto.view

import lotto.Lottos
import lotto.Rank

class OutputView(private val formatter: LottoViewFormatter) {

    fun printLottoTickets(lottos: Lottos) {
        print(buildLottoTickets(lottos))
    }

    fun printFinalReport(rankCounts: Map<Rank, Int>, profitRate: Double) {
        println(buildFinalReport(rankCounts, profitRate))
    }

    private fun buildLottoTickets(lottos: Lottos): String = buildString {
        appendLine()
        appendLine(formatter.formatPurchaseMessage(lottos))
        appendLine(formatter.formatLottoTickets(lottos))
    }

    private fun buildFinalReport(rankCounts: Map<Rank, Int>, profitRate: Double): String = buildString {
        appendLine()
        appendLine("Winning Statistics")
        appendLine("---")
        appendLine(formatter.formatWinningStatistics(rankCounts))
        appendLine(formatter.formatProfitRate(profitRate))
    }

}
