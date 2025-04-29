package lotto.view

import lotto.Lotto
import lotto.domain.Rank

interface OutputPrinter {
    fun printPurchasedTickets(tickets: List<Lotto>): Unit
    fun printLottoResult(rankCount: Map<Rank, Int>): Unit
    fun printProfitRate(profitRate: Double): Unit
    fun close(): Unit
}
