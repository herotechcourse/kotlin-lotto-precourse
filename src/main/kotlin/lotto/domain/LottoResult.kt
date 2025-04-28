package lotto.domain

class LottoResult(
    private val tickets: List<LottoTicket>,
    private val winningNumbers: WinningNumbers

) {
    fun getRankCounts(): Map<Rank, Int> {
        val counts = mutableMapOf<Rank, Int>().apply {
            Rank.entries.forEach { rank -> put(rank, 0) }
        }
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            val matchCount = numbers.count { winningNumbers.getWinningNumbers().contains(it) }
            val bonusMatch = numbers.contains(winningNumbers.getBonusNumber())
            val rank = Rank.of(matchCount, bonusMatch)
            counts[rank] = counts.getValue(rank) + 1
        }
        return counts
    }

    fun getTotalPrize(): Long {
        return getRankCounts().entries.sumOf { (rank, count) -> rank.prize * count }
    }

    fun calculateYield(money: Money): Double {
        if (money.amount == 0) return 0.0
        val rate = getTotalPrize().toDouble() * 100 / money.amount
        return String.format("%.1f", rate).toDouble()
    }
}