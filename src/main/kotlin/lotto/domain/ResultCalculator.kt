package lotto.domain

import LottoResult

class ResultCalculator {
    fun calculate(tickets: List<Lotto>, winningNumbers: WinningNumbers): LottoResult {
        val prizeCounts = mutableMapOf<Prize, Int>()

        tickets.forEach { ticket ->
            val prize = winningNumbers.match(ticket)
            prizeCounts[prize] = prizeCounts.getOrDefault(prize, 0) + 1
        }

        return LottoResult(prizeCounts)
    }

    fun calculateProfitRate(result: LottoResult, amount: Int): Double {
        val totalReward = result.statistics.entries.sumOf { it.key.reward * it.value }
        return (totalReward.toDouble() / amount) * 100
    }
}
