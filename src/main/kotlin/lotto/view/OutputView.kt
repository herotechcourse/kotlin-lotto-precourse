package lotto.view

import lotto.Lotto

class OutputView(private val formatter: LottoViewFormatter = LottoViewFormatter()) {

    fun printLottoTickets(lottoTickets: List<Lotto>) {
        print(buildLottoTickets(lottoTickets))
    }

    fun printFinalReport(rankCounts: List<CountRankResponse>, profitRate: Double) {
        println(buildFinalReport(rankCounts, profitRate))
    }

    private fun buildLottoTickets(lottoTickets: List<Lotto>): String = buildString {
        appendLine()
        appendLine(formatter.formatPurchaseMessage(lottoTickets))
        appendLine(formatter.formatLottoTickets(lottoTickets))
    }

    private fun buildFinalReport(rankCounts: List<CountRankResponse>, profitRate: Double): String = buildString {
        appendLine()
        appendLine("Winning Statistics")
        appendLine("---")
        appendLine(formatter.formatWinningStatistics(rankCounts))
        appendLine(formatter.formatProfitRate(profitRate))
    }

}
