package lotto

class WinningStatistics(private val rankCounts: Map<Rank, Int>) {

    init {
        require(rankCounts.isNotEmpty()) { "rankCounts must not be empty" }
    }

    fun getCount(rank: Rank): Int = rankCounts[rank] ?: 0

    fun profitRate(): Double {
        val totalPrize: Prize = calculateTotalPrize()
        val cost: Money = calculateCost()

        return (totalPrize / cost) * PERCENT
    }

    private fun calculateTotalPrize(): Prize = rankCounts.entries
        .map { (rank, count) -> rank.prize * count }
        .fold(Prize.ZERO) { acc, prize -> acc + prize }

    private fun calculateCost(): Money = Money.fromTicketCount(rankCounts.values.sum())

    companion object {
        private const val PERCENT = 100.0
    }
}
