package lotto.model

class LottoResult(
    private val lottery: LottoStorage,
    private val winningLotto: WinningLotto

) {
    private val rankCountMap: MutableMap<LottoRank, Int> = mutableMapOf()

    init {
        calculateRanks()
    }

    private fun calculateRanks() {
        for (lotto in lottery.getAll()) {
            val matchCount = lotto.countMatch(winningLotto.getWinningNumbers())
            val matchBonus = lotto.isContainsNumber(winningLotto.getBonusNumber())
            val rank = LottoRank.of(matchCount, matchBonus)
            rankCountMap[rank] = rankCountMap.getOrDefault(rank, 0) + 1
        }
    }

    fun getCount(rank: LottoRank): Int {
        return rankCountMap.getOrDefault(rank, 0)
    }

    private fun calculateTotalPrize(): Int {
        return rankCountMap.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        val totalPrize = calculateTotalPrize()
        if (purchaseAmount == 0 || totalPrize == 0) {
            return 0.0
        }
        val rawRate = (totalPrize.toDouble() / purchaseAmount) * 100
        return String.format("%.1f", rawRate).toDouble()
    }
}