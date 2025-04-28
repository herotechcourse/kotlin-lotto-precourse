package lotto.view

import lotto.domain.LottoPurchase
import lotto.domain.LottoResult
import lotto.domain.Prize

object OutputView {
    fun printPurchaseResult(purchase: LottoPurchase) {
        println("\nYou have purchased ${purchase.ticketCount} tickets.")
        purchase.tickets.forEach { println(it) }
    }

    fun printWinningStatistics(result: LottoResult) {
        println("\nWinning Statistics")
        println("---")
        
        val prizes = listOf(
            Prize.FIFTH to "3 Matches",
            Prize.FOURTH to "4 Matches",
            Prize.THIRD to "5 Matches",
            Prize.SECOND to "5 Matches + Bonus Ball",
            Prize.FIRST to "6 Matches"
        )

        prizes.forEach { (prize, description) ->
            val count = result.results[prize] ?: 0
            val formattedAmount = prize.amount.toLong().toString().reversed()
                .chunked(3)
                .joinToString(",")
                .reversed()
            println("$description ($formattedAmount KRW) – $count tickets")
        }
    }

    fun printReturnRate(result: LottoResult, purchaseAmount: Int) {
        val returnRate = result.calculateReturnRate(purchaseAmount)
        println("\nTotal return rate is $returnRate%.")
    }
}
