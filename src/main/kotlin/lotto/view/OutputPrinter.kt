package lotto.view

import lotto.domain.LotteryTickets

interface OutputPrinter {
    fun printPurchasedTickets(tickets: LotteryTickets): Unit
    fun printLottoResult(tickets: LotteryTickets): Unit
    fun printProfitRate(profitRate: Any): Unit
    fun close(): Unit
}
