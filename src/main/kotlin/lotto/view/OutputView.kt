package lotto.view

class OutputView(private val formatter: LottoViewFormatter = LottoViewFormatter()) {

    fun printError(message: String?) {
        println("$ERROR_PREFIX ${message ?: DEFAULT_ERROR_MESSAGE}")
    }

    fun printLottoTickets(lottoTickets: List<List<Int>>) {
        print(buildLottoTickets(lottoTickets))
    }

    fun printFinalReport(rankCounts: List<CountRankResponse>, profitRate: Double) {
        println(buildFinalReport(rankCounts, profitRate))
    }

    private fun buildLottoTickets(lottoTickets: List<List<Int>>): String = buildString {
        appendLine()
        appendLine(formatter.formatPurchaseMessage(lottoTickets))
        appendLine(formatter.formatLottoTickets(lottoTickets))
    }

    private fun buildFinalReport(rankCounts: List<CountRankResponse>, profitRate: Double): String = buildString {
        appendLine()
        appendLine(FINAL_REPORT_HEADER)
        appendLine(SECTION_SEPARATOR)
        appendLine(formatter.formatWinningStatistics(rankCounts))
        appendLine(formatter.formatProfitRate(profitRate))
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val DEFAULT_ERROR_MESSAGE = "Unknown error"
        private const val FINAL_REPORT_HEADER = "Winning Statistics"
        private const val SECTION_SEPARATOR = "---"
    }
}
