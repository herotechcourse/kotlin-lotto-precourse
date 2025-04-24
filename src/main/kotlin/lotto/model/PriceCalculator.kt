package lotto.model

class PriceCalculator {
    fun calculateReturnRate(
        purchaseAmount: Int,
        countOfRanks: Map<Rank, Int>,
    ): Float {
        val winningPrice = calculateWinningPrice(countOfRanks)
        return winningPrice.toFloat() / purchaseAmount * 100
    }

    private fun calculateWinningPrice(countOfRanks: Map<Rank, Int>): Int {
        var totalAmount = 0
        countOfRanks.forEach { countOfRank ->
            totalAmount += countOfRank.key.winningMoney * countOfRank.value
        }
        return totalAmount
    }
}
