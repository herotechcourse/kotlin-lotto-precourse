package lotto.service

import lotto.Lotto
import lotto.domain.Rank
import lotto.domain.WinningLotto

object LottoStatistics {
    // This function calculates the statistics of the tickets compared to the winning numbers.
    fun calculate(tickets: List<Lotto>, winningLotto: WinningLotto): Map<Rank, Int> {
        val statistics = mutableMapOf<Rank, Int>()
        tickets.forEach {
            val rank = winningLotto.getRank(it)
            statistics[rank] = statistics.getOrDefault(rank, 0) + 1
        }
        return statistics
    }
}
