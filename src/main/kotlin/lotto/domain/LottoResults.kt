package lotto.domain

import lotto.Lotto

class LottoResults(purchasedLottos: List<Lotto>, winningLotto: WinningLotto) {
    private val results: Map<PrizeRank , Int>

    init {
        this.results = calculateCounts(purchasedLottos, winningLotto)
    }

    fun getCount(rank: PrizeRank): Int {
        return results.getOrDefault(rank, 0)
    }

    fun getTotalWinnings(): Int {
        return results.entries.fold(0) { total, entry ->
            total + entry.key.prize * entry.value
        }
    }

    fun getprofitRate(amount: Int): Double {
        val totalWinnings = getTotalWinnings()
        val profitRate = (totalWinnings.toDouble() / amount.toDouble()) * 100
        return profitRate
    }

    fun getStatistics(): Map<PrizeRank , Int> {
        return results.toMap()
    }

    private fun calculateCounts(purchasedLottos: List<Lotto>, winningLotto: WinningLotto): Map<PrizeRank, Int> {
        val mutableResults = PrizeRank.entries.associateWith { 0 }.toMutableMap()

        purchasedLottos.forEach { lotto ->
            val matchResult = winningLotto.match(lotto)
            val rank = PrizeRank.from(matchResult.matchCnt, matchResult.hasBonus)

            if (rank != null) {
                mutableResults[rank] = mutableResults.getOrDefault(rank, 0) + 1
            }
        }
        return mutableResults.toMap()
    }
}