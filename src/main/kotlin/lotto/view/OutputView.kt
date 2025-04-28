package lotto.view

import lotto.domain.Rank
import lotto.services.LottoStatistics

class OutputView {
    fun purchasedTicket(count: Int) {
        println("\nYou have purchased $count tickets.")
    }

    fun ticketNumber(tickets: List<List<Int>>) {
        tickets.forEach {
            println(it)
        }
    }

    fun printStatistics(statistics: LottoStatistics) {
        println("\nWinning Statistics")
        println("---")
        val result = statistics.result

        println(result)
        Rank.values().forEach { prize ->
            val count = result[prize] ?: 0
            println(
                when (prize) {
                    Rank.THREE -> "3 Matches (5,000 KRW) – $count tickets"
                    Rank.FOUR -> "4 Matches (50,000 KRW) – $count tickets"
                    Rank.FIVE -> "5 Matches (1,500,000 KRW) – $count tickets"
                    Rank.FIVE_BONUS -> "5 Matches + Bonus Ball (30,000,000 KRW) – $count tickets"
                    Rank.SIX -> "6 Matches (2,000,000,000 KRW) – $count tickets"
                }
            )
        }
    }

    fun printProfitRate(rate: Double) {
        println("Total return rate is $rate%.")
    }
}