package lotto.view
import lotto.domain.LottoTickets
import lotto.domain.Rank

object OutputView {

    fun printPurchasedTickets(lottoTickets: LottoTickets) {
        println("\nYou have purchased ${lottoTickets.size()} tickets.")
        lottoTickets.getAll().forEach { lotto ->
            println(lotto)
        }
    }

    fun printWinningStatistics(rankCount: Map<Rank, Int>) {
        println("\nWinning Statistics")
        println("---")
        Rank.values()
            .filter { it != Rank.NONE }
            .sortedByDescending { it.matchCount }
            .forEach { rank ->
                val count = rankCount[rank] ?: 0
                println("${rank.matchCount} Matches${if (rank == Rank.SECOND) " + Bonus Ball" else ""} (${formatPrize(rank.prize)} KRW) – $count tickets")
            }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${profitRate}%.")
    }

    private fun formatPrize(prize: Int): String {
        return "%,d".format(prize)
    }
}