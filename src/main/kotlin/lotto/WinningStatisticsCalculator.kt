package lotto

object WinningStatisticsCalulator {
    fun run(lottoTickets: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): Map<Rank, Int> {
        val winningStatistics = mutableMapOf<Rank, Int>()


        Rank.values().sortedBy { it.matchedCount }.forEach { rank ->
            val matchedCount = lottoTickets.count { ticket ->
                ticket.getNumbers().intersect(winningLotto.getNumbers()).size == rank.matchedCount
            }
            val bonusMatched = lottoTickets.count { ticket ->
                ticket.getNumbers().intersect(winningLotto.getNumbers()).size == rank.matchedCount && ticket.getNumbers().contains(bonusNumber)
            }

            winningStatistics[rank] = matchedCount + bonusMatched
        }

        return winningStatistics
    }
}