package lotto

class Result(
    private val tickets: List<Ticket>,
    private val winningNumbers: WinningNumbers
) {
    private val results: MutableMap<Rank, Int> = mutableMapOf()

    init {
        // Initialize the results map with all Ranks set to 0
        Rank.values().forEach { results[it] = 0 }
        calculateResults()
    }

    private fun calculateResults() {
        tickets.forEach { ticket ->
            val matchCount = ticket.getNumbers().count { it in winningNumbers.getWinningNumbers() }
            val bonusMatch = winningNumbers.getBonusNumber() in ticket.getNumbers()
            val rank = Rank.from(matchCount, bonusMatch)
            // Update the count of how many times this rank occurred
            results[rank] = results.getOrDefault(rank, 0) + 1
        }
    }

    // Returns how many tickets achieved a given rank
    fun getResultCount(rank: Rank): Int {
        return results[rank] ?: 0
    }

    // Calculates total profit rate based on purchase amount
    fun getTotalProfitRate(purchaseAmount: Int): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prizeMoney.toLong() * count }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}