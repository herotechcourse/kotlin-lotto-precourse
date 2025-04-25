package lotto.model

import lotto.Lotto
import lotto.util.Validator

class WinningLotto private constructor(
    private val lotto: Lotto
) {
    private var bonusNum: Int = 0

    fun getBonusNum(): Int = bonusNum
    fun getNumbers(): List<Int> = lotto.getNumbers()

    companion object {
        fun create(winningNumber: String): WinningLotto {
            basicValidateWinningNumber(winningNumber)
            val parsedNumber = parseEachNumber(winningNumber)
            validateWinningNumber(parsedNumber)
            val numbers = parsedNumber.map { it.toInt() }
            val lotto = Lotto(numbers)
            return WinningLotto(lotto)
        }

        private fun parseEachNumber(winningNumber: String): List<String> {
            return winningNumber.split(",")
        }

        private fun basicValidateWinningNumber(winningNumber: String) {
            Validator.isEmptyInput(winningNumber)
        }

        private fun validateWinningNumber(parsedNumbers: List<String>) {
            Validator.isEqualListSize(parsedNumbers, Lotto.LOTTO_NUMBER_COUNT)
            parsedNumbers.forEach {
                Validator.isDigitString(it)
                Validator.isInteger(it)
            }
            Validator.isNotDuplicate(parsedNumbers)
        }
    }

    fun addBonusNumber(bonusNum: String) {
        val bonusNumber = validateBonusNumber(bonusNum)
        this.bonusNum = bonusNumber
    }

    private fun validateBonusNumber(bonusNumber: String): Int {
        Validator.isEmptyInput(bonusNumber)
        Validator.isDigitString(bonusNumber)
        Validator.isInteger(bonusNumber)

        val bonusNumberInt = bonusNumber.toInt()
        Validator.isNumberWithinRange(
            bonusNumberInt,
            Lotto.LOTTO_NUMBER_MINIMUM,
            Lotto.LOTTO_NUMBER_MAXIMUM
        )
        Validator.isNotInList(getNumbers(), bonusNumberInt)
        return bonusNumberInt
    }
}
