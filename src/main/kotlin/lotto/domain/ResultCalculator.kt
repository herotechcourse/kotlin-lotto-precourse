package lotto.domain

import lotto.Lotto

/**
 * Calculates lottery results and profit rate.
 *
 * @param winningNumbers set of 6 winning numbers
 * @param bonusNumber single bonus number
 */
class ResultCalculator(
    private val winningNumbers: Set<Int>, private val bonusNumber: Int
) {

    /**
     * Tallies how many tickets fall into each PrizeRank.
     */
    fun calculate(lottoes: List<Lotto>): Map<PrizeRank, Int> {
        val rankFreq = mutableMapOf<PrizeRank, Int>().withDefault { 0 }

        for (lotto in lottoes) {
            val nums = lotto.getNumbers().toSet()

            val matchCount: Int = lotto.matchCount(winningNumbers)
            val bonusMatch: Boolean = lotto.hasBonus(bonusNumber)

            PrizeRank.of(matchCount, bonusMatch)?.let { rank ->
                rankFreq[rank] = rankFreq.getValue(rank) + 1
            }
        }

        return rankFreq
    }

    /**
     * Calculates the profit rate as a percentage, rounded to one decimal.
     */
    fun profitRate(resultCounts: Map<PrizeRank, Int>, purchaseAmount: Int): Double {
        val totalPrize = resultCounts.entries.sumOf { it.key.prize * it.value }

        val rate = totalPrize.toDouble() / purchaseAmount * 100

        return String.format("%.1f", rate).toDouble()
    }
}
