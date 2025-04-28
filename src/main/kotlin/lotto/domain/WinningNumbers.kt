package lotto.domain

import lotto.Lotto

/**
 * Represents last week's winning numbers and the bonus number.
 */
class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!numbers.contains(bonusNumber)) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }

    /**
     * Calculates how many numbers match between a Lotto ticket and the winning numbers.
     *
     * @param ticket the Lotto ticket to compare
     * @return the count of matching numbers
     */
    fun countMatchingNumbers(ticket: Lotto): Int {
        return ticket.getNumbers().count { numbers.contains(it) }
    }

    /**
     * Checks if a Lotto ticket matches the bonus number.
     *
     * @param ticket the Lotto ticket to check
     * @return true if bonus number matches, false otherwise
     */
    fun matchBonusNumber(ticket: Lotto): Boolean {
        return ticket.getNumbers().contains(bonusNumber)
    }
}
