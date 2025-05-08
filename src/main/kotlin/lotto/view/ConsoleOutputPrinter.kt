package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank

class ConsoleOutputPrinter: OutputPrinter {
    private fun getRankCountMessage(rankCount: Map.Entry<Rank, Int>): String {
        val rank = rankCount.key
        val prizeFormatted = "%,d".format(rank.prize)

        val builder = StringBuilder()
        builder.append("${rank.matchCount} Matches ")
        if (rank.bonusBallRequired)
            builder.append("+ Bonus Ball ")
        return builder.append("($prizeFormatted ${Lotto.CURRENCY}) – ${rankCount.value} tickets").toString()
    }

    private fun getRankStaticsMessage(rankCount: Map<Rank, Int>): String {
        val stringBuilder = StringBuilder()

        rankCount.forEach {
            stringBuilder.appendLine(getRankCountMessage(it))
        }

        return stringBuilder.toString()
    }

    private fun getProfitRateMessage(profitRate: Double): String {
        return "Total return rate is ${String.format("%.1f", profitRate)}%.\n"
    }

    override fun printPurchasedTickets(tickets: List<Lotto>) {
        val stringBuilder = StringBuilder()

        stringBuilder.appendLine("You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            stringBuilder.appendLine(it)
        }

        println(stringBuilder.toString())
    }

    override fun printLottoResult(lottoResult: LottoResult) {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine(RESULT_DESCRIPTION)
        stringBuilder.appendLine(LINE_SEPARATOR)

        stringBuilder.appendLine(getRankStaticsMessage(lottoResult.lottoRanks))
        stringBuilder.appendLine(getProfitRateMessage(lottoResult.profitRate))

        println(stringBuilder.toString())
    }

    override fun printErrors(reasons: List<String>) {
        println("$ERROR_TAG ${reasons.joinToString(", ")}")
    }

    override fun printTryAgain() {
        println("please try again.\n")
    }


    override fun close() {
        Console.close()
    }

    companion object {
        private const val ERROR_TAG = "[ERROR]"
        private const val LINE_SEPARATOR = "---"
        private const val RESULT_DESCRIPTION = "Winning Statics"
    }
}
