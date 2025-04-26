package lotto

class LottoEvaluator {
    fun compareTickets(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<PrizeRanks, Int> {
        val results = mutableMapOf<PrizeRanks, Int>().withDefault { 0 }

        tickets.forEach { ticket ->
            val matchedNumbers = ticket.getNumbers().count { it in winningNumbers }
            val hasBonus = bonusNumber in ticket.getNumbers()

            val prize = PrizeRanks.determineTier(matchedNumbers, hasBonus)
            results[prize] = results.getValue(prize) + 1
        }

        return results
    }
}