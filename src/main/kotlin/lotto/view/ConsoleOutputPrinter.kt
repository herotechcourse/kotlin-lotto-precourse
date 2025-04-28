package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
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

    override fun printLottoResult(rankCount: Map<Rank, Int>) {
        val stringBuilder = StringBuilder()

        stringBuilder.appendLine("Winning Statics")
        stringBuilder.appendLine("---")
        rankCount.forEach {
            stringBuilder.append("${it.key.matchCount} Matches ")
            if (it.key.bonusBallRequired)
                stringBuilder.append("+ Bonus Ball ")
            stringBuilder.appendLine("(${String.format("%,d", it.key.prize)} ${Lotto.CURRENCY}) – ${it.value} tickets" )}

        println(stringBuilder.toString())
    }

    override fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }

    override fun close() {
        Console.close()
    }
}
