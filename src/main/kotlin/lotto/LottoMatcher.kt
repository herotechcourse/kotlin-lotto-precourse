package lotto

class LottoMatcher(val winningNumbers: List<Int>, val bonusNumber: Int) {
    private fun getPrizeRank(ticket: Lotto): PrizeRank {
        val matchCount = ticket.getNumbers().count { it in winningNumbers }
        val bonusMatched = ticket.getNumbers().contains(bonusNumber)
        return PrizeRank.from(matchCount, bonusMatched)
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
        val prizeRanks = tickets.map { ticket -> getPrizeRank(ticket) }
        return countPrizeRank(prizeRanks, tickets.size * LottoFactory.TICKET_PRICE)
    }
}