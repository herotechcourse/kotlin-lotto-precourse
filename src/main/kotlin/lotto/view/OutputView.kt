package lotto.view

import lotto.Lotto
import lotto.LottoResult
import lotto.Rank

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printStatistics(result: LottoResult, amount: Int) {
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) - ${result.countByRank(Rank.FIFTH)} ticket(s)")
        println("4 Matches (50,000 KRW) - ${result.countByRank(Rank.FOURTH)} ticket(s)")
        println("5 Matches (1,500,000 KRW) - ${result.countByRank(Rank.THIRD)} ticket(s)")
        println("5 Matches + Bonus Ball (30,000,000 KRW) - ${result.countByRank(Rank.SECOND)} ticket(s)")
        println("6 Matches (2,000,000,000 KRW) - ${result.countByRank(Rank.FIRST)} ticket(s)")

        val rate = result.calculateReturnRate(amount)
        println("Total return rate is ${"%.1f".format(rate)}%.")
    }
}
