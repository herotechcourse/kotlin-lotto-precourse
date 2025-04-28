package lotto

import org.assertj.core.internal.Numbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        winningNumbersValidations(numbers)
    }

    // TODO: Implement additional functions

    private fun winningNumbersValidations(numbers: List<Int>) {
        validateNumbers(numbers)
        validateUniqueNumbers(numbers)
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 1 || it > 45 })
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    private fun validateUniqueNumbers(numbers: List<Int>) {
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be unique.")
        }
    }

    fun validateBonusNumber(number: Int) {
        if (number < 1 || number > 45 )
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
    }

    fun validateBonusWinningUnique(number: Int) {
        if (number in numbers)
            throw IllegalArgumentException("[ERROR] Bonus number must be different than the winning numbers.")
    }

    fun checkMatchingNumbers(tickets: List<List<Int>>, bonusNumber: Int): Map<PrizeTier, Int> {
        val results = initializeResults()
        tickets.forEach { ticket ->
            val tier = determinePrizeTier(ticket, bonusNumber)
            updateResults(results, tier)
        }
        return results
    }

    private fun initializeResults(): MutableMap<PrizeTier, Int> {
        val results = mutableMapOf<PrizeTier, Int>()
        PrizeTier.values().forEach { tier ->
            results[tier] = 0
        }
        return results
    }

    private fun countMatches(ticket: List<Int>): Int {
        return ticket.count { it in numbers }
    }

    private fun hasBonusMatch(ticket: List<Int>, bonusNumber: Int): Boolean {
        return bonusNumber in ticket
    }

    private fun determinePrizeTier(ticket: List<Int>, bonusNumber: Int): PrizeTier? {
        val matchCount = countMatches(ticket)
        val hasBonusMatch = hasBonusMatch(ticket, bonusNumber)
        return when {
            matchCount == 6 -> PrizeTier.FIRST
            matchCount == 5 && hasBonusMatch -> PrizeTier.SECOND
            matchCount == 5 -> PrizeTier.THIRD
            matchCount == 4 -> PrizeTier.FOURTH
            matchCount == 3 -> PrizeTier.FIFTH
            else -> null
        }
    }

    private fun updateResults(results: MutableMap<PrizeTier, Int>, tier: PrizeTier?) {
        if (tier != null) {
            results[tier] = results[tier]!! + 1
        }
    }

    enum class PrizeTier(val matchCount: Int, val prize: Int, val description: String) {
        FIFTH(3, 5_000, "3 Matches"),
        FOURTH(4, 50_000, "4 Matches"),
        THIRD(5, 1_500_000, "5 Matches"),
        SECOND(5, 30_000_000, "5 Matches + Bonus Ball"),
        FIRST(6, 2_000_000_000, "6 Matches");
        fun getDisplayText(count: Int): String {
            val prizeFormatted = String.format("%,d", prize)
            return "$description ($prizeFormatted KRW) – $count tickets"
        }
    }

    fun calculateTotalPrize(matchResults: Map<PrizeTier, Int>): Int {
        return matchResults.entries.sumOf { (tier, count) ->
            tier.prize * count
        }
    }

    fun calculateReturnRate(purchaseAmount: Int, totalPrize: Int): Double {
        return if (purchaseAmount > 0) {
            (totalPrize.toDouble() / purchaseAmount) * 100
        } else {
            0.0
        }
    }
}
