package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

class ConsoleOutputPrinter: OutputPrinter {
    override fun printPurchasedTickets(tickets: List<Lotto>) {
        val stringBuilder = StringBuilder()

        stringBuilder.appendLine("You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            stringBuilder.appendLine(it)
        }

        println(stringBuilder.toString())
    }

    override fun printLottoResult(tickets: List<Lotto>) {
        TODO("Not yet implemented")
    }

    override fun printProfitRate(profitRate: Any) {
        TODO("Not yet implemented")
    }

    override fun close() {
        Console.close()
    }
}
