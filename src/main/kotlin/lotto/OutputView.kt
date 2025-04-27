package lotto

class OutputView {
    fun printTickets(lottoTickets: List<Lotto>) {
        println("\nYou have purchased ${lottoTickets.size} tickets.")
        lottoTickets.forEach { println(it.getNumbers()) }
    }

    fun printWinningStatistics(statistics: Map<Rank, Int>) {
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

    fun totalReturnRate(totalPrizeMoney: Double, purchaseAmount: Int) {
        val totalReturnRate = (totalPrizeMoney / purchaseAmount) * 100
        println("Total return rate is ${totalReturnRate}%.")
    }
}