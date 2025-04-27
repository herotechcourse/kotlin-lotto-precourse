package lotto

class Lotto(private val numbers: List<Int>) {
    // Constructor validation
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    // Returns sorted numbers for display
    fun getNumbers(): List<Int> = numbers.sorted()

    // Counts how many numbers match with winning numbers
    fun getMatchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    // Checks if bonus number is in the ticket
    fun hasBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    // Determines the prize rank based on matches and bonus
    fun getRank(winningNumbers: List<Int>, bonusNumber: Int): LottoRank {
        val matchCount = getMatchCount(winningNumbers)
        val hasBonus = hasBonusNumber(bonusNumber)
        return LottoRank.getRank(matchCount, hasBonus)
    }
}