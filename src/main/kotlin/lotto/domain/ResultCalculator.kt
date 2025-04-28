package lotto.domain

import lotto.Lotto

class ResultCalculator{
    fun calculateResults(
        purchasedLottos: List<Lotto>,
        winningNumbers: WinningNumbers,
        bonusNumber: BonusNumber
    ): Map<Rank, Int> {
        return purchasedLottos.groupingBy { lotto ->
            val matchCount = lotto.getNumbers().count { it in winningNumbers.numbers }
            val hasBonus = bonusNumber.number in lotto.getNumbers()
            Rank.getRank(matchCount, hasBonus)
        }.eachCount()
    }

    fun calculateProfitRate(results: Map<Rank, Int>, purchaseAmount: Int): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        return (totalPrize.toDouble() / purchaseAmount * 100).toDouble()
    }
}
