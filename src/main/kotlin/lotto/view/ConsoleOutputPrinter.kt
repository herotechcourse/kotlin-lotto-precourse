package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.domain.LottoResult

class ConsoleOutputPrinter: OutputPrinter {
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
        lottoResult.lottoRanks.forEach { rank, count -> stringBuilder.appendLine("$rank – $count tickets") }
        stringBuilder.appendLine()
        stringBuilder.appendLine( "Total return rate is ${String.format("%.1f", lottoResult.profitRate)}%.\n")

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
