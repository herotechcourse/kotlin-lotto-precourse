package lotto.domain

import lotto.Lotto

class LottoCalculator(
    winningNumbers: WinningNumbers,
    bonusNumber: LottoNumber,
    tickets: List<Lotto>,
    private val ranks: Ranks = Ranks()
) {
    val rankCount: Map<Rank, Int>
    val profitRate: Double

    init {
        rankCount = calculateRankCount(winningNumbers, bonusNumber, tickets)
        profitRate = calculateProfitRate(tickets.size, rankCount)
    }

    private fun calculateRankCount(winningNumbers: WinningNumbers, bonusNumber: LottoNumber, tickets: List<Lotto>): Map<Rank, Int> {
        val rankCounter = ranks.createCounter()

        tickets.forEach {
            val matchCount = it.countMatches(winningNumbers.toList())
            val bonusBallMatched = winningNumbers.contains(bonusNumber) && !it.contains(bonusNumber.value)
            val foundRank = ranks.getOrNull(matchCount, bonusBallMatched) ?: return@forEach
            rankCounter[foundRank] = rankCounter[foundRank]?.plus(1) ?: 0
        }

        return rankCounter
    }

    private fun calculateProfitRate(ticketCount: Int, rankCount: Map<Rank, Int>, ticketPrice: Int = Lotto.PRICE): Double {
        val paid = ticketPrice * ticketCount
        val profitPrize = rankCount.entries.sumOf { (rank, count) -> rank.prize * count }

        return profitPrize.toDouble() / paid * 100
    }
}

