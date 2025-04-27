package lotto

class OutputView {
    fun showTickets(lottoTickets: List<List<Int>>) {
        println("\nYou have purchased ${lottoTickets.size} tickets.")
        lottoTickets.forEach { println(it) }
    }

    fun showWinningStatistics(statistics: Map<Rank, Int>) {
        println("Winning Statistics:")
        println("---")
        statistics.forEach { (rank, count) ->
            if (rank.bonus) {
                println("${rank.matchedCount} Matches + Bonus Ball (${rank.getPrizeMoneyInKRW()}) – ${count} tickets")
            } else {
                println("${rank.matchedCount} Matches (${rank.getPrizeMoneyInKRW()}) – ${count} tickets")
            }
        }
    }

    fun showTotalReturnRate(totalReturnRate: Double) {
        println("Total return rate is ${totalReturnRate}%.")
    }
}