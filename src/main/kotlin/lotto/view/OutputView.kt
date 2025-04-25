package lotto.view

import lotto.models.Lotto
import lotto.models.MatchPrize

class OutputView {

    fun displayPurchasedTicketsInfo(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")

        tickets.forEach { ticket ->
            println(ticket.toString())
        }
    }

    fun displayResult(rankCount: Map<MatchPrize, Int>, returnRate: Double) {
        println("\nWinning Statistics")
        println("---")
        println("3 Matches (5,000 KRW)d – ${rankCount[MatchPrize.THREE] ?: 0} tickets")
        println("4 Matches (50,000 KRW)d – ${rankCount[MatchPrize.FOUR] ?: 0} tickets")
        println("5 Matches (1,500,000 KRW)d – ${rankCount[MatchPrize.FIVE] ?: 0} tickets")
        println("5 Matches + Bonus (30,000,000 KRW)d – ${rankCount[MatchPrize.FIVEWITHBONUS] ?: 0} tickets")
        println("6 Matches (2,000,000,000 KRW)d – ${rankCount[MatchPrize.SIX] ?: 0} tickets")

        println("Total return rate is %.1f%%.".format(returnRate))
    }
}