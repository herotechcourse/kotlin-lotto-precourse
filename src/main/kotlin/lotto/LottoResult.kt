package lotto

/**
 * Handles the evaluation of lotto tickets against the winning numbers
 * and calculates the total earnings and rank statistics.
 */
class LottoResult {
    private val resultMap = mutableMapOf<Rank, Int>()
    private var totalEarning = 0

    /**
     * Evaluates a single lotto ticket against the winning numbers and bonus number.
     * Updates the total earnings and the result map with the corresponding rank.
     *
     * @param ticket the lotto ticket to evaluate
     * @param winningNumbers the list of winning numbers
     * @param bonusNumber the bonus number
     */
    fun evaluateAndRecord(ticket: Lotto, winningNumbers: List<Int>, bonusNumber: Int) {
        val matchCount = ticket.countMatches(winningNumbers)
        val bonusMatch = ticket.contains(bonusNumber)
        val rank = Rank.from(matchCount, bonusMatch)
        totalEarning += rank.prize
        record(rank)
    }

    /**
     * Calculates and returns the profit rate based on the total earnings and the investment amount.
     *
     * @param investment the total amount of money spent
     * @return the profit rate as a percentage
     */
    fun getProfitRate(investment: Int): Double {
        return totalEarning.toDouble() / investment * 100
    }

    /**
     * Returns a copy of the rank statistics map showing the count of tickets per rank.
     *
     * @return a map of Rank to the number of tickets that achieved that rank
     */
    fun getRankStatistics(): Map<Rank, Int> = resultMap.toMap()

    /**
     * Records a ticket's rank into the result map by incrementing the count for the given rank.
     *
     * @param rank the rank achieved by a ticket
     */
    private fun record(rank: Rank) {
        resultMap[rank] = resultMap.getOrDefault(rank, 0) + 1
    }
}
