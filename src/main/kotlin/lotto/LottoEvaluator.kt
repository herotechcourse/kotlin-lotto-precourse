package lotto

class LottoEvaluator {
    /**
     * Compare a list of lotto tickets against winning numbers and a bonus number to determine prizes.
     *
     * @param tickets The list of Lotto tickets to evaluate.
     * @param winningNumbers The winning numbers (6 unique integers).
     * @param bonusNumber The bonus number (must not be in winningNumbers).
     * @return containing:
     *   - A map of `PrizeRanks` to the count of winning tickets for each tier.
     *   - The total profit rate as a percentage.
     */
    fun compareTickets(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Pair<Map<PrizeRanks, Int>, Double> {
        val results = mutableMapOf<PrizeRanks, Int>().withDefault { 0 }
        var totalWinnings = 0L

        tickets.forEach { ticket ->
            val matchedNumbers = ticket.getNumbers().count { it in winningNumbers }
            val hasBonus = bonusNumber in ticket.getNumbers()

            val prize = PrizeRanks.determineTier(matchedNumbers, hasBonus)
            results[prize] = results.getValue(prize) + 1
            totalWinnings += prize.prizeMoney.toLong()
        }

        val profitRate = calculateProfitRate(totalWinnings, tickets.size)
        return Pair(results, profitRate)
    }

    private fun calculateProfitRate(totalWinnings: Long, ticketCount: Int): Double {
        val totalSpent = ticketCount * 1000L
        return (totalWinnings.toDouble() / totalSpent) * 100
    }
}