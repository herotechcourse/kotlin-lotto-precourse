package lotto

object LottoResult {
    fun evaluate(tickets: List<Lotto>, winning: WinningNumbers): Map<Rank, Int> {
        return tickets.map { ticket ->
            val matchCount = ticket.numbers.count { it in winning.numbers }
            val matchBonus = ticket.numbers.contains(winning.bonus)
            Rank.from(matchCount, matchBonus)
        }.groupingBy { it }.eachCount()
    }

    fun calculateProfit(results: Map<Rank, Int>, amount: Int): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        return totalPrize.toDouble() / amount
    }
}
