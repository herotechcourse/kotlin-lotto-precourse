package lotto.domain

object ProfitCalculator {

    fun calculate(statistics: Map<Rank, Int>, purchaseAmount: Int): Double {
        require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than 0" }

        val totalPrize = statistics.entries.sumOf { (rank, count) ->
            rank.prize * count
        }

        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}