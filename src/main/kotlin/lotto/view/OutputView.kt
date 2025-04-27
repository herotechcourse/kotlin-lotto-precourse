package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Rank
import lotto.domain.LottoTicket

object OutputView {
    fun printPurchasedTickets(tickets: List<LottoTicket>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.lotto.getNumbers()) }
    }

    fun printStatistics(result: LottoResult, purchaseAmount: Int) {
        println("\nWinning Statistics\n---")
        result.getRankCounts().forEach { (rank, count) ->
            val bonusText = if (rank.requiresBonus) "+ Bonus Ball " else ""
            println("${rank.match} Matches $bonusText(${rank.prize} KRW) – $count tickets")
        }
        val rate = result.totalPrize().toDouble() / purchaseAmount * 100
        println("Total return rate is ${"%.1f".format(rate)}%.")
    }
}
