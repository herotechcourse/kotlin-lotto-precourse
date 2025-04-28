package lotto.domain

import lotto.Lotto

/**
 * Represents the result of the lottery game, counting tickets by rank and calculating profit.
 *
 * @property prizeResults map storing how many tickets won each Rank
 */
class Result {

    private val prizeResults: MutableMap<Rank, Int> = mutableMapOf()

    /**
     * Evaluates a list of Lotto tickets against the winning numbers.
     *
     * @param tickets the list of Lotto tickets purchased
     * @param winningNumbers the winning numbers and bonus number
     */
    fun evaluate(tickets: List<Lotto>, winningNumbers: WinningNumbers) {
        tickets.forEach { ticket ->
            val matchCount = winningNumbers.countMatchingNumbers(ticket)
            val bonusMatch = winningNumbers.matchBonusNumber(ticket)
            val rank = Rank.find(matchCount, bonusMatch)
            prizeResults[rank] = prizeResults.getOrDefault(rank, 0) + 1
        }
    }

    /**
     * Calculates the total prize money won.
     *
     * @return total winnings
     */
    fun totalPrize(): Int {
        return prizeResults.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
    }

    /**
     * Calculates the profit rate based on the amount spent.
     *
     * @param amount total purchase amount
     * @return profit rate as a percentage (rounded to one decimal)
     */
    fun profitRate(amount: Int): Double {
        if (amount == 0) return 0.0
        val profit = totalPrize().toDouble() / amount * 100
        return String.format("%.1f", profit).toDouble()
    }

    /**
     * Returns a copy of the prize results map.
     */
    fun getPrizeResults(): Map<Rank, Int> = prizeResults.toMap()
}
