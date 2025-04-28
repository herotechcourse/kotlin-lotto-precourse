package lotto

object ProfitRateCalaulator {
    fun calculateProfitRate(purchaseAmount : Int) : Double{
        val rankStatistics = TicketChecker.getStatistics()
        var sum = 0
        sum += (rankStatistics[Rank.SIX] ?: 0) * Rank.SIX.prize
        sum += (rankStatistics[Rank.FIVE_BONUS] ?: 0) * Rank.FIVE_BONUS.prize
        sum += (rankStatistics[Rank.FIVE] ?: 0) * Rank.FIVE.prize
        sum += (rankStatistics[Rank.FOUR] ?: 0) * Rank.FOUR.prize
        sum += (rankStatistics[Rank.THREE] ?: 0) * Rank.THREE.prize

        if (purchaseAmount == 0) return 0.0

        return (sum.toDouble() / purchaseAmount.toDouble()) * 100
    }
}
