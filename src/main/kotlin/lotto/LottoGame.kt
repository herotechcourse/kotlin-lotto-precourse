package lotto

class LottoGame(
    private val tickets: MutableList<Lotto>, private val winningNumbers: List<Int>, private val bonusNumber: Int
) {
    fun start(): LottoResults {
        val results = LottoResults()

        for (ticket in tickets) {
            val matches = ticket.calculateMatches(winningNumbers)

            when (matches) {
                LottoRanks.MATCH_3.countOfMatches -> results.increaseMatchResult(LottoRanks.MATCH_3)
                LottoRanks.MATCH_4.countOfMatches -> results.increaseMatchResult(LottoRanks.MATCH_4)
                LottoRanks.MATCH_5.countOfMatches -> {
                    if (ticket.hasBonusNumber(bonusNumber)) {
                        results.increaseMatchResult(LottoRanks.MATCH_5_AND_BONUS)
                    } else {
                        results.increaseMatchResult(LottoRanks.MATCH_5)
                    }
                }
                LottoRanks.MATCH_6.countOfMatches -> results.increaseMatchResult(LottoRanks.MATCH_6)
            }
        }
        return results
    }
}
