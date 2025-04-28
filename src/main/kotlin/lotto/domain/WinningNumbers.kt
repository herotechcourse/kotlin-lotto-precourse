package lotto.domain

import lotto.LottoConstants
import lotto.exception.LottoInputException

/**
 * Represents the winning lottery numbers, including the main numbers and a bonus number.
 * Ensures that the numbers follow lottery rules (6 unique numbers between 1-45 and a bonus number).
 */
class WinningNumbers(private val numbers: List<Int>, bonusNumber: Int) {
    var bonusNumber: Int = bonusNumber
        private set

    init {
        if (numbers.size != LottoConstants.LOTTO_NUMBERS_COUNT)
            throw LottoInputException.InvalidWinningNumbers("You must provide exactly 6 numbers.")
        if (numbers.distinct().size != LottoConstants.LOTTO_NUMBERS_COUNT)
            throw LottoInputException.InvalidWinningNumbers("Winning numbers must all be unique.")
        if (numbers.any { it !in LottoConstants.LOTTO_MIN_NUMBER..LottoConstants.LOTTO_MAX_NUMBER })
            throw LottoInputException.InvalidWinningNumbers("Numbers must be between 1 and 45.")
        if (bonusNumber !in LottoConstants.LOTTO_MIN_NUMBER..LottoConstants.LOTTO_MAX_NUMBER)
            throw LottoInputException.InvalidBonusNumber(bonusNumber)
        if (numbers.contains(bonusNumber))
            throw LottoInputException.InvalidBonusWithWinningNumbers(bonusNumber)
    }

    fun getNumbers(): List<Int> = numbers.toList()
}