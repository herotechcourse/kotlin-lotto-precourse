package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank

class ConsoleOutputPrinter: OutputPrinter {

    override fun printPurchasedTickets(tickets: List<Lotto>) {
        val stringBuilder = StringBuilder()

        stringBuilder.appendLine("You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            stringBuilder.appendLine(it)
        }

        println(stringBuilder.toString())
    }

    private fun getRankStaticsMessage(rankCount: Map<Rank, Int>): String {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("Winning Statics")
        stringBuilder.appendLine("---")
        rankCount.forEach {
            stringBuilder.append("${it.key.matchCount} Matches ")
            if (it.key.bonusBallRequired)
                stringBuilder.append("+ Bonus Ball ")
            stringBuilder.appendLine("(${String.format("%,d", it.key.prize)} ${Lotto.CURRENCY}) – ${it.value} tickets" )}
        return stringBuilder.toString()
    }

    private fun getProfitRateMessage(profitRate: Double): String {
        return "Total return rate is ${String.format("%.1f", profitRate)}%.\n"
    }

    override fun printLottoResult(lottoResult: LottoResult) {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine(RESULT_DESCRIPTION)
        stringBuilder.appendLine("---")

        stringBuilder.appendLine(getRankStaticsMessage(lottoResult.lottoRanks))
        stringBuilder.appendLine(getProfitRateMessage(lottoResult.profitRate))

        println(stringBuilder.toString())
    }

    override fun close() {
        Console.close()
    }

    companion object {
        private const val RESULT_DESCRIPTION = "Winning Statics"
    }
}
