package lotto.presentation

import lotto.Lotto
import lotto.domain.Rank

object OutputView {
    private val RANK_DISPLAY = mapOf(
        Rank.FIFTH  to "3 Matches (5,000 KRW)",
        Rank.FOURTH to "4 Matches (50,000 KRW)",
        Rank.THIRD  to "5 Matches (1,500,000 KRW)",
        Rank.SECOND to "5 Matches + Bonus Ball (30,000,000 KRW)",
        Rank.FIRST  to "6 Matches (2,000,000,000 KRW)"
    )

    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
        println()
    }

    fun printStatistics(stats: Map<Rank, Int>, totalPrize: Double) {
        println("Winning Statistics")
        println("---")
        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST).forEach { r ->
            val name = RANK_DISPLAY.getValue(r)
            val count = stats[r]
            println("$name – $count tickets")
        }
        val rate = "%.1f".format(totalPrize)
        println("Total return rate is $rate%.")
    }
}
