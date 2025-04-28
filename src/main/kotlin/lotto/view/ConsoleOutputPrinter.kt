package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LotteryTickets

class ConsoleOutputPrinter: OutputPrinter {
    override fun printPurchasedTickets(tickets: LotteryTickets) {
        val printBuilder = StringBuilder()
        printBuilder.append("You have purchased ${tickets.size} tickets.\n")
        tickets.toList().forEach {
            printBuilder.append(it.toNumberList().toString())
            printBuilder.append('\n')
        }
    }

    override fun printLottoResult(tickets: LotteryTickets) {
        TODO("Not yet implemented")
    }

    override fun printProfitRate(profitRate: Any) {
        TODO("Not yet implemented")
    }

    override fun close() {
        Console.close()
    }
}
