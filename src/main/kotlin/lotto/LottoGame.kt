package lotto

class LottoGame(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int,
    private val tickets: List<Lotto>
) {
    fun countWinningTickets(): Map<PrizeRankCriteria, Int> {
        val result = mutableMapOf<PrizeRankCriteria, Int>().withDefault { 0 }
        tickets.forEach { it ->
            val matchCount = matchCount(it)
            val matchBonus = containsBonus(it)
            val prizeRank = PrizeRankCriteria.rank(matchCount, matchBonus)
            result[prizeRank] = result.getValue(prizeRank) + 1
        }
        return result
    }

    private fun matchCount(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in winningNumbers }
    }

    private fun containsBonus(lotto: Lotto): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }
}