package lotto

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: Int) {

    init {
        require(bonusNumber in 1..45) { "Bonus number must be between 1 and 45." }
    }

    fun getRank(lotto: Lotto): LottoRank {
        val matchNumber = lotto.countMatches(winningNumbers)
        val isBonusMatched = lotto.containsNumber(bonusNumber)

        return LottoRank.findByMatch(matchNumber, isBonusMatched)
    }

    fun getMultipleLottoRanks(lottoTickets: List<Lotto>): List<LottoRank> {
        val ranks = lottoTickets.map { ticket ->
            getRank(ticket)
        }
        return ranks
    }
}
