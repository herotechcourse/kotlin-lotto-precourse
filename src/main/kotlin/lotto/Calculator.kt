package lotto

object Calculator {
    fun rate(result: Map<PrizeRankCriteria, Int>, purchaseAmount: Int): Double {
        if (purchaseAmount < 1) throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
        val totalWinningAmount = winningSum(result)
        return (totalWinningAmount.toDouble() / purchaseAmount) * 100
    }

    private fun winningSum(result: Map<PrizeRankCriteria, Int>): Long {
        return result.entries.sumOf { (rank, count) ->
            rank.prizeAmount.toLong() * count
        }
    }
}