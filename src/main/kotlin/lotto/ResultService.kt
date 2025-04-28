package lotto

object ResultService {
    fun calculateResult(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()

        for (lotto in lottos) {
            val matchCount = lotto.countMatch(winningNumbers)
            val bonusMatch = lotto.containsBonus(bonusNumber)
            val rank = Rank.from(matchCount, bonusMatch)

            result[rank] = result.getOrDefault(rank, 0) + 1
        }

        return result
    }

    fun calculateProfitRate(
        result: Map<Rank, Int>,
        purchaseAmount: Int
    ): Double {
        val totalPrize = result.entries.sumOf { (rank, count) ->
            rank.prizeAmount * count
        }

        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}
