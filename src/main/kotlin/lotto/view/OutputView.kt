package lotto.view

import lotto.Lotto
import lotto.domain.LottoResults
import lotto.domain.PrizeRank

class OutputView {
    fun displayPurchasedTickets(ticketCnt: Int, tickets: List<Lotto>) {
        println("\nYou have purchased ${ticketCnt} tickets.")

        tickets.forEach { lotto ->
            println(lotto.getNumbers().sorted())
        }
    }

    fun displayWinningStatistics(results: LottoResults) {
        println("\nWinning Statistics")
        println("---")
        println("${PrizeRank.FIFTH.matchCnt} Matches (${String.format("%,d", PrizeRank.FIFTH.prize)} KRW) - ${results.getCount(PrizeRank.FIFTH)} tickets")
        println("${PrizeRank.FOURTH.matchCnt} Matches (${String.format("%,d", PrizeRank.FOURTH.prize)} KRW) - ${results.getCount(PrizeRank.FOURTH)} tickets")
        println("${PrizeRank.THIRD.matchCnt} Matches (${String.format("%,d", PrizeRank.THIRD.prize)} KRW) - ${results.getCount(PrizeRank.THIRD)} KRW) - ${results.getCount(PrizeRank.THIRD)} tickets")
        println("${PrizeRank.SECOND.matchCnt} Matches + Bonus Ball (${String.format("%,d", PrizeRank.SECOND.prize)} KRW) - ${results.getCount(PrizeRank.SECOND)} tickets")
        println("${PrizeRank.FIRST.matchCnt} Matches (${String.format("%,d", PrizeRank.FIRST.prize)} KRW) - ${results.getCount(PrizeRank.FIRST)} tickets")
    }

    fun displayProfitRate(results: LottoResults, purchaseAmout: Int) {
        val profitRate = results.getprofitRate(purchaseAmout)
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}