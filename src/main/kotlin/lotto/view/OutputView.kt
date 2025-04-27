package lotto.view

import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank

object OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket)
        }
    }

    fun printResults(results: LottoResult, profitRate: Double) {
        println("Winning Statistics")
        println("---")
        println("${formatRank(Rank.FIFTH)} – ${results.getCountByRank(Rank.FIFTH)} tickets")
        println("${formatRank(Rank.FOURTH)} – ${results.getCountByRank(Rank.FOURTH)} tickets")
        println("${formatRank(Rank.THIRD)} – ${results.getCountByRank(Rank.THIRD)} tickets")
        println("${formatRank(Rank.SECOND)} – ${results.getCountByRank(Rank.SECOND)} tickets")
        println("${formatRank(Rank.FIRST)} – ${results.getCountByRank(Rank.FIRST)} tickets")
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }

    private fun formatRank(rank: Rank): String {
        return when (rank) {
            Rank.FIRST -> "6 Matches (2,000,000,000 KRW)"
            Rank.SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
            Rank.THIRD -> "5 Matches (1,500,000 KRW)"
            Rank.FOURTH -> "4 Matches (50,000 KRW)"
            Rank.FIFTH -> "3 Matches (5,000 KRW)"
        }
    }
}
