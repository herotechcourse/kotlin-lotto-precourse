package lotto

object Validator {
    fun validatePurchaseAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(Constants.ERROR_MULTIPLE_OF_1000)
        }
    }
    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(Constants.ERROR_INVALID_WINNING_COUNT)
        }

        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(Constants.ERROR_INVALID_NUMBER_RANGE)
        }

        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException(Constants.ERROR_DUPLICATED_NUMBER)
        }
    }

    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException(Constants.ERROR_INVALID_BONUS_NUMBER_RANGE)
        }

        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException(Constants.ERROR_DUPLICATED_BONUS)
        }
    }
}