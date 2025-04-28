package lotto.domain

import lotto.Lotto

class LottoResultChecker {

    private fun matchTicketWithWinningNumbers(
            ticket: Lotto,
            winningNumbers: Lotto,
            bonusNumber: Int
    ): MatchResult {
        val matchCount = ticket.getNumbers.count { winningNumbers.getNumbers.contains(it) }
        val hasBonusNumber = ticket.getNumbers.contains(bonusNumber)

        return MatchResult(matchCount, hasBonusNumber)
    }

    private fun getWinningRank(matchResult: MatchResult): WinningPrizeRanks {
        return matchResult.getWinningRank()
    }

    fun checkLottoResults(
            tickets: List<Lotto>,
            winningNumbers: Lotto,
            bonusNumber: Int
    ): Map<WinningPrizeRanks, Int> {
        return tickets
                .groupBy { ticket ->
                    val matchResult =
                            matchTicketWithWinningNumbers(ticket, winningNumbers, bonusNumber)
                    getWinningRank(matchResult)
                }
                .mapValues { it.value.size }
    }

    fun calculateTotalPrize(winningCounts: Map<WinningPrizeRanks, Int>): Int {
        return winningCounts.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    fun getProfitRate(totalPrize: Int, purchaseAmount: Int): Double {
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}
