package lotto

object LottoResult {
    fun calculate(
        tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int
    ): Map<PrizeRank, Int> {
        return tickets.mapNotNull { ticket ->
            val matchCount = ticket.matchCount(winningNumbers)
            val bonusMatch = ticket.contains(bonus)
            PrizeRank.of(matchCount, bonusMatch)
        }.groupingBy { it }.eachCount()
    }
}
