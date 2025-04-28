package lotto.view

import lotto.Lotto

interface OutputPrinter {
    fun printPurchasedTickets(tickets: List<Lotto>): Unit
    fun printLottoResult(tickets: List<Lotto>): Unit
    fun printProfitRate(profitRate: Any): Unit
    fun close(): Unit
}
