package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame(
    val purchaseAmount: UInt,
    var winningNumbers: List<Int> = emptyList(),
    var bonusNumber: Int = 0,
    val numberOfTickets: Int
) {
    companion object {
        private val PRIZE_AMOUNTS = mapOf(
            MatchCategory.THREE_MATCHES to 5_000,
            MatchCategory.FOUR_MATCHES to 50_000,
            MatchCategory.FIVE_MATCHES to 1_500_000,
            MatchCategory.FIVE_MATCHES_AND_BONUS to 30_000_000,
            MatchCategory.SIX_MATCHES to 2_000_000_000
        )
    }

    private val tickets = mutableListOf<Lotto>()
    private val results = mutableMapOf<MatchCategory, Int>()

    init {
        createMultipleTickets(numberOfTickets)
    }

    fun getTickets(): List<Lotto> {
        return tickets.toList()
    }

    private fun createSingleTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    private fun createMultipleTickets(numberOfTickets: Int) {
        repeat(numberOfTickets) {
            tickets.add(createSingleTicket())
        }
    }

    fun getResults(): Map<MatchCategory, Int> {
        if (results.isEmpty()) {
            calculateResults()
        }
        return results.toMap()
    }

    private fun calculateResults() {
        initializeResults()
        tickets.forEach { ticket ->
            updateResultsForTicket(ticket)
        }
    }

    private fun initializeResults() {
        MatchCategory.entries.forEach { results[it] = 0 }
    }

    private fun updateResultsForTicket(ticket: Lotto) {
        val matchCount = ticket.countMatchingNumbers(winningNumbers)
        val hasBonus = ticket.containsBonusNumber(bonusNumber)
        val category = getCategoryForTicket(matchCount, hasBonus)
        if (category != null) {
            results[category] = results.getOrDefault(category, 0) + 1
        }
    }

    private fun getCategoryForTicket(matchCount: Int, hasBonus: Boolean): MatchCategory? {
        when (matchCount) {
            3 -> return MatchCategory.THREE_MATCHES
            4 -> return MatchCategory.FOUR_MATCHES
            5 -> return getFiveMatchCategory(hasBonus)
            6 -> return MatchCategory.SIX_MATCHES
        }
        return null
    }

    private fun getFiveMatchCategory(hasBonus: Boolean): MatchCategory {
        if (hasBonus) {
            return MatchCategory.FIVE_MATCHES_AND_BONUS
        }
        return MatchCategory.FIVE_MATCHES
    }

    private fun calculateTotalWinnings(): Int {
        var totalWinnings = 0
        for ((matchCategory, ticketCount) in results) {
            val prizeForCategory = PRIZE_AMOUNTS.getValue(matchCategory)
            val winningsForCategory = prizeForCategory * ticketCount
            totalWinnings += winningsForCategory
        }

        return totalWinnings
    }

    fun getReturnRate(): Double {
        val totalWinnings = calculateTotalWinnings()
        return (totalWinnings.toDouble() / purchaseAmount.toDouble()) * 100
    }
}
