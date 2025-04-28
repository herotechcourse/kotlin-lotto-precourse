package lotto

class LottoResult(private val purchaseAmount: Int) {
    /** Stores the count of winning lottos for each rank (excluding MISS). */
    private val results: MutableMap<LottoRank, Int> = LottoRank.entries
        .filter { it != LottoRank.MISS }
        .associateWith { 0 }
        .toMutableMap()

    fun recordWinning(rank: LottoRank) {
        results[rank] = results.getOrDefault(rank, 0) + 1
    }

    fun calculateStatistics(lottos: List<Lotto>, winningLotto: WinningLotto) {
        lottos.forEach { lotto ->
            val rank = winningLotto.match(lotto)
            recordWinning(rank)
        }
    }

    fun getResults(): Map<LottoRank, Int> {
        return results.toMap()
    }

    fun calculateProfitRate(): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        if (purchaseAmount == 0) return 0.0
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
} 