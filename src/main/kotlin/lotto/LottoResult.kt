package lotto

class LottoResult(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    private val lottoResults = mutableListOf<LottoRank>()

    fun analyzeResult(lottoTickets: List<Lotto>) {
        lottoResults.clear()
        lottoResults.addAll(lottoTickets.map { lotto ->
            val match = lotto.countingWinningNumbers(winningNumbers)
            val isBonus = lotto.isContainsBonusNumber(bonusNumber)
            LottoRank.from(match, isBonus)
        })
    }

    fun getStatistics(): Map<LottoRank, Int> {
        return LottoRank.entries
            .associateWith { lottoRank -> lottoResults.count { it == lottoRank } }
            .filterKeys { it != LottoRank.MISS }
    }

    fun calculateReturnRate(purchaseAmount: Int): Double {
        val totalPrize = lottoResults.sumOf { it.prize.toLong() }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}