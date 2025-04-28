package lotto

object ProfitRateCalculator {
    fun calculateProfitRate(purchaseAmount: Int): Double {
        val rankStatistics = TicketChecker.getStatistics()
        var totalPrize = 0
        for (rank in Rank.entries) {
            val count = rankStatistics[rank] ?: 0
            totalPrize += count * rank.prize
        }
        if (purchaseAmount == 0) return 0.0

        return (totalPrize.toDouble() / purchaseAmount.toDouble()) * 100
    }
}
