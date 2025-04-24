package lotto

class LottoResult {
    private val resultMap = mutableMapOf<Rank, Int>()
    private var totalEarning = 0

    fun evaluateAndRecord(ticket: Lotto, winningNumbers: List<Int>, bonusNumber: Int) {
        val matchCount = ticket.countMatches(winningNumbers)
        val bonusMatch = ticket.contains(bonusNumber)
        val rank = Rank.from(matchCount, bonusMatch)
        totalEarning += rank.prize
        record(rank)
    }

    fun getProfitRate(investment: Int): Double {
        return totalEarning.toDouble() / investment * 100
    }

    fun getRankStatistics(): Map<Rank, Int> = resultMap.toMap()

    private fun record(rank: Rank) {
        resultMap[rank] = resultMap.getOrDefault(rank, 0) + 1
    }
}
