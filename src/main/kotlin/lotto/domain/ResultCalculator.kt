package lotto.domain

object ResultCalculator {
    fun calculateMatchedLottoCount(
        lottos: Lottos,
        winningNumbers: WinningNumbers,
        bonusNumber: BonusNumber
    ): Map<LottoRank, Int> {
        return lottos.tickets
            .map { it.match(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }

    fun calculateProfitRate(matchedLottoCount: Map<LottoRank, Int>, purchaseAmount: Int): Double {
        val totalPrize = matchedLottoCount.entries.sumOf { (rank, count) ->
            rank.prize * count
        }

        val profitRate = totalPrize.toDouble() / purchaseAmount * 100
        return String.format("%.1f", profitRate).toDouble()
    }
}