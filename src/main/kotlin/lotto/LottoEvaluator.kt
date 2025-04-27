package lotto

class LottoEvaluator {
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