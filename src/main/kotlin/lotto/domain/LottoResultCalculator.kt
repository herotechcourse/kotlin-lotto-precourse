package lotto.domain

import lotto.Lotto

class LottoResultCalculator (private val winning: WinningNumbers, private val bonus: BonusNumber) {
    fun calculateStats(lottos: List<Lotto>): Map<Rank, Int> {
        // 1) create initial map with each Rank set to 0
        val initial = Rank.entries.associateWith { 0 }

        val counted = countRanks(lottos)

        // 3) merge with initial map, using 0 for Ranks with no entries
        return initial.mapValues { (rank, _) -> counted[rank] ?: 0 }
    }

    fun calculateRate(stats: Map<Rank, Int>, purchase: PurchaseAmount): Double =
        calculateTotalPrize(stats).toDouble() / purchase.amount * 100

    private fun calculateTotalPrize(stats: Map<Rank, Int>): Int =
        stats.entries.sumOf { (rank, count) -> rank.prize * count }

    // Returns how many times each prize rank occurs among the given Lotto tickets.
    private fun countRanks(lottos: List<Lotto>): Map<Rank, Int> =
        lottos
            .mapNotNull { determineRank(it) }
            .groupingBy { it }
            .eachCount()

    /**
     * Determines the prize rank for a given Lotto ticket.
     * Counts how many numbers match the winning numbers and checks if the bonus number matches.
     */
    private fun determineRank(lotto: Lotto): Rank? {
        val matchCount = lotto.matchCount(winning)
        val bonusMatch = lotto.containsNumber(bonus)

        return Rank.valueOf(matchCount, bonusMatch)
    }
}
