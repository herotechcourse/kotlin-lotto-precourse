package lotto

class LottoResultEvaluator {
    fun evaluate(
        tickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Rank, Int> {
        return tickets
            .map { ticket ->
                val matches = ticket.countMatchingNumbers(winningNumbers)
                val bonusMatched = ticket.hasNumber(bonusNumber)
                Rank.of(matches, bonusMatched)
            }
            .groupingBy { it }
            .eachCount()
            .filterKeys { it != Rank.NONE }
            .withDefault { 0 }
    }

    fun calculateProfitRate(
        tickets: List<Lotto>,
        results: Map<Rank, Int>
    ): Double {
        val totalWon = results.entries.sumOf { (rank, count) -> rank.prize * count }
        val totalCost = tickets.size * Config.TICKET_PRICE
        return (totalWon.toDouble() / totalCost) * 100
    }
}
