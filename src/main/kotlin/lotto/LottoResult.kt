package lotto

class LottoResult(private val tickets: List<Lotto>, private val winningLotto: List<Int>, private val bonusNumber: Int) {
    private val results: Map<PrizeRank, Int> = computeResults()

    private fun computeResults(): Map<PrizeRank, Int> {
        val rankCount = mutableMapOf<PrizeRank, Int>()

        for (ticket in tickets) {
            val rank = getTicketRank(ticket)
            countRankOccurrences(rank, rankCount)
        }
        return rankCount
    }

    private fun countRankOccurrences(rank: PrizeRank, map: MutableMap<PrizeRank, Int>) {
        if (rank != PrizeRank.NONE) {
            map[rank] = map.getOrDefault(rank, 0) + 1
        }
    }

    private fun getTicketRank(ticket: Lotto): PrizeRank {
        val matchCount = ticket.countMatches(winningLotto)
        val matchBonus = ticket.containBonus(bonusNumber)
        return PrizeRank.from(matchCount, matchBonus)
    }

    private fun getTotalWinnings(): Int {
        return results.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    fun getRankCounts(): Map<PrizeRank, Int> {
        return PrizeRank.entries
            .filter { it != PrizeRank.NONE }
            .associateWith { results.getOrDefault(it, 0) }
    }

    fun getProfitRate(purchaseAmount: Int): Double {
        val profit = getTotalWinnings().toDouble()
        return (profit / purchaseAmount) * 100
    }
}
