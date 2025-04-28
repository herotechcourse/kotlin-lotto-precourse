package lotto.domain

import lotto.exception.LottoInputException

/**
 * Represents the winning lottery numbers, including the main numbers and a bonus number.
 * Ensures that the numbers follow lottery rules (6 unique numbers between 1-45 and a bonus number).
 */
class WinningNumbers(private val numbers: List<Int>, bonusNumber: Int) {
    var bonusNumber = bonusNumber
        private set

    init {
        if (numbers.size != 6)
            throw LottoInputException.InvalidWinningNumbers("You must provide exactly 6 numbers.")
        if (numbers.distinct().size != 6)
            throw LottoInputException.InvalidWinningNumbers("Winning numbers must all be unique.")
        if (numbers.any { it !in 1..45 })
            throw LottoInputException.InvalidWinningNumbers("Numbers must be between 1 and 45.")
        if (bonusNumber !in 1..45)
            throw LottoInputException.InvalidBonusNumber(bonusNumber)
        if (numbers.contains(bonusNumber))
            throw LottoInputException.InvalidBonusWithWinningNumbers(bonusNumber)
    }

    fun getNumbers(): List<Int> = numbers.toList()
}