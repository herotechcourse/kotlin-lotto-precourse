package lotto.domain

import WinningNumbers
import lotto.Lotto

class ResultCalculator {
    fun calculate(tickets: List<Lotto>, winningNumbers: WinningNumbers): LottoResult {
        val prizeCounts = mutableMapOf<PrizeCategory, Int>().withDefault { 0 }

        tickets.forEach { ticket ->
            val prize = winningNumbers.match(ticket)
            prizeCounts[prize] = prizeCounts.getValue(prize) + 1
        }

        return LottoResult(prizeCounts)
    }

    fun calculateProfitRate(result: LottoResult, amount: Int): Double {
        val totalReward = result.statistics.entries.sumOf { it.key.prizeAmount * it.value }
        return (totalReward.toDouble() / amount) * 100
    }
}
