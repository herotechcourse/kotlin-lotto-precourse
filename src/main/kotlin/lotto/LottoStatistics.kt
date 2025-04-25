package lotto

object LottoStatistics {
    fun calculate(tickets: List<Lotto>, winningLotto: WinningLotto): Map<Rank, Int> {
        val statistics = mutableMapOf<Rank, Int>()
        tickets.forEach {
            val rank = winningLotto.getRank(it)
            statistics[rank] = statistics.getOrDefault(rank, 0) + 1
        }
        return statistics
    }
}