package lotto

class LottoMatcher(val winningNumbers: List<Int>, val bonusNumber: Int) {
    private fun calculateMatchResult(ticket: Lotto): MatchResult {
        val matchCount = ticket.getNumbers().count { it in winningNumbers }
        val bonusMatched = ticket.getNumbers().contains(bonusNumber)
        return MatchResult(matchCount, bonusMatched)
    }

    private fun mapToRank(tickets: List<Lotto>): List<PrizeRank> {
        return tickets.map { ticket ->
            val matchResult = calculateMatchResult(ticket)
            PrizeRank.from(matchResult.matchCount, matchResult.bonusMatched)
        }
    }

    private fun countPrizeRank(prizeRanks: List<PrizeRank>, amount: Int): PrizeResult {
        val prizeCount: MutableMap<PrizeRank, Int> = PrizeRank.entries
            .associateWith { 0 }
            .toMutableMap()
        var totalPrize = 0L
        for (rank in prizeRanks) {
            totalPrize += rank.prizeMoney
            prizeCount[rank] = prizeCount.getValue(rank) + 1
        }
        return PrizeResult(prizeCount, totalPrize / amount.toFloat())
    }

    fun calculatePrizeResult(tickets: List<Lotto>): PrizeResult {
        val prizeRanks = mapToRank(tickets)
        return countPrizeRank(prizeRanks, tickets.size * 1_000)
    }
}