package lotto.domain

import lotto.exception.LottoInputException

class WinningNumbers(private val numbers: List<Int>, private val bonusNumber: Int) {
    init {
        if (numbers.size != 6)
            throw LottoInputException.InvalidWinningNumbers("You must provide exactly 6 numbers.")
        if (numbers.distinct().size != 6)
            throw LottoInputException.InvalidWinningNumbers("Winning numbers must all be unique.")
        if (numbers.any { it !in 1..45 })
            throw LottoInputException.InvalidWinningNumbers("Numbers must be between 1 and 45.")
        if (bonusNumber !in 1..45)
           throw LottoInputException.InvalidBonusNumber(bonusNumber)
    }

    fun getWinningNumbers(): List<Int> = numbers.toList()
    fun getBonusNumber(): Int = bonusNumber
}