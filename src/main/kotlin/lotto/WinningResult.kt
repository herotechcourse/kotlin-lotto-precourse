package lotto

class WinningResult(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    fun match(lottos: List<Lotto>): Map<Rank, Int> {
        return lottos
            .map { determineRank(it) }
            .filter { it != Rank.NONE }
            .groupingBy { it }
            .eachCount()
    }


    private fun determineRank(lotto: Lotto): Rank {
        val matchCount = countMatches(lotto)
        val bonusMatched = isBonusMatched(lotto)
        return Rank.from(matchCount, bonusMatched)
    }

    fun calculateTotalPrize(matchResult: Map<Rank, Int>): Int {
        return matchResult.entries.sumOf { (rank, count) ->
            rank.prizeMoney * count
        }
    }

    fun calculateProfitRate(totalPrize: Int, purchaseAmount: Int): Double {
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }

    private fun countMatches(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in winningNumbers }
    }

    private fun isBonusMatched(lotto: Lotto): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }
}
