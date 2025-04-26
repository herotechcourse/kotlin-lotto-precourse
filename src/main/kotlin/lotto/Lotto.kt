package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    // Function to check how many numbers match the winning numbers and bonus number
    fun matchCount(winningNumbers: List<Int>, bonusNumber: Int): Pair<Int, Boolean> {
        val matchedNumbers = numbers.intersect(winningNumbers).size
        val isBonusMatch = numbers.contains(bonusNumber)
        return Pair(matchedNumbers, isBonusMatch)
    }

    // Function to calculate prize based on matching results
    fun calculatePrize(matchedCount: Int, isBonusMatch: Boolean): Long {
        return when (matchedCount) {
            6 -> 2_000_000_000L       // 1st Prize: 6 matches
            5 -> if (isBonusMatch) 30_000_000L   // 2nd Prize: 5 matches + bonus
            else 1_500_000L        // 3rd Prize: 5 matches
            4 -> 50_000L               // 4th Prize: 4 matches
            3 -> 5_000L                // 5th Prize: 3 matches
            else -> 0L                 // No prize
        }
    }
}
