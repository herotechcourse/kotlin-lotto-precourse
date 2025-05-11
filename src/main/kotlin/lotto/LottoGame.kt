package lotto

class LottoGame(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
    private val tickets: List<Lotto>
) {
    fun countWinningTickets(): Map<PrizeRankCriteria, Int> {
        val result = mutableMapOf<PrizeRankCriteria, Int>().withDefault { 0 }
        tickets.forEach { it ->
            val matchCount = it.matchCount(winningNumbers)
            val matchBonus = it.containsNumber(bonusNumber)
            val prizeRank = PrizeRankCriteria.rank(matchCount, matchBonus)
            result[prizeRank] = result.getValue(prizeRank) + 1
        }
        return result
    }
}