package lotto

import java.util.Locale

class Lotto(private val numbers: List<Int>) {
    init {
        validateNumbers(numbers)
    }

    private fun validateNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers.toList() // Returns a copy to ensure immutability

    fun getSortedNumbers(): List<Int> = numbers.sorted()

    override fun toString(): String = getSortedNumbers().toString()

    companion object {
        // winning number logic implementation

        // parse winning numbers from input string
        fun parseNumbers(input: String): List<Int> =
            input.split(",").mapNotNull { it.trim().toIntOrNull() }

        // parse bonus number from input string
        fun parseNumber(input: String): Int? = input.trim().toIntOrNull()

        // validate winning numbers
        fun getWinningNumbers(input: String): List<Int> {
            val numbers = parseNumbers(input)
            validateWinningNumbers(numbers)
            return numbers
        }

        // validate bonus number
        fun getBonusNumber(input: String, winningNumbers: List<Int>): Int {
            val bonusNumber = parseNumber(input)
                ?: throw IllegalArgumentException("Invalid input. Please enter a valid number.")
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        }

        // validate winning numbers for length, uniqueness, and range
        private fun validateWinningNumbers(numbers: List<Int>) {
            require(numbers.size == 6) { "You must enter exactly 6 numbers." }
            require(numbers.toSet().size == 6) { "Numbers must be unique." }
            require(numbers.all { it in 1..45 }) { "All numbers must be between 1 and 45." }
        }

        // validate bonus number for range and uniqueness
        private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
            require(bonusNumber in 1..45) { "Bonus number must be between 1 and 45." }
            require(bonusNumber !in winningNumbers) { "Bonus number must not be included in the winning numbers." }
        }

        // evaluate results based on winning numbers and bonus number
        fun evaluateResults(
            tickets: List<Lotto>,
            winningNumbers: Set<Int>,
            bonusNumber: Int
        ): Result {
            val rankCounts = mutableMapOf<Rank, Int>()
            var totalWinnings = 0

            for (ticket in tickets) {
                val matchCount = ticket.getNumbers().count { it in winningNumbers }
                val isBonusMatched = bonusNumber in ticket.getNumbers()

                val rank = Rank.determineRank(matchCount, isBonusMatched)
                rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
                totalWinnings += rank.prize
            }

            return Result(rankCounts, totalWinnings)
        }

        // calculate profit rate based on total winnings and purchase amount
        data class Result(
            val rankCounts: Map<Rank, Int>,
            val totalWinnings: Int
        ) {
            // calculate profit rate
            fun calculateProfitRate(purchaseAmount: Int): Double {
                return if (purchaseAmount > 0) {
                    (totalWinnings.toDouble() / purchaseAmount) * 100
                } else {
                    0.0
                }
            }

            // display statistics
            fun displayStatistics(purchaseAmount: Int) {
                val profitRate = calculateProfitRate(purchaseAmount)
                Rank.entries
                    .filter { it.matchCount >= 3 }
                    .sortedWith(
                        compareBy(
                            { it.matchCount },
                            { !it.requiresBonus })
                    )
                    .forEach { rank ->
                        println(
                            "${rank.matchCount} Matches${if (rank.requiresBonus) " + Bonus Ball" else ""} (${
                                "%,d".format(Locale.US, rank.prize)
                            } KRW) – ${
                                rankCounts.getOrDefault(rank, 0)
                            } tickets"
                        )
                    }
                println("Total return rate is ${"%.1f".format(Locale.US, profitRate)}%.")
            }
        }
    }
}

// Rank enum class to represent different ranks and their properties
enum class Rank(
    val matchCount: Int,
    val requiresBonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0); // For tickets that don't win

    companion object {
        fun determineRank(matchCount: Int, isBonusMatched: Boolean): Rank {
            return entries.firstOrNull {
                it.matchCount == matchCount && it.requiresBonus == isBonusMatched
            } ?: if (matchCount >= 3) NONE else NONE
        }
    }
}
