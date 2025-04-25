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

}