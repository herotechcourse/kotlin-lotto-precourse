package lotto.model

import lotto.Lotto

class WinningChecker {
    fun countMatches(
        userLottos: List<Lotto>,
        winningLotto: Lotto,
        bonusNumber: Int,
    ): Map<Rank, Int> {
        val countOfRanks = userLottos
            .mapNotNull { rankOf(it, winningLotto, bonusNumber) }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()
        fillMissingRanks(countOfRanks)
        return countOfRanks
    }

    private fun rankOf(userLotto: Lotto, winningLotto: Lotto, bonusNumber: Int): Rank? {
        val matchCount = userLotto.numbers.intersect(winningLotto.numbers.toSet()).size
        return when (matchCount) {
            6 -> Rank.FIRST
            5 -> if (bonusNumber in userLotto.numbers) Rank.SECOND else Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> null
        }
    }

    private fun fillMissingRanks(countOfRanks: MutableMap<Rank, Int>) {
        for (rank in listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)) {
            if (rank !in countOfRanks.keys) {
                countOfRanks[rank] = 0
            }
        }
    }
}
