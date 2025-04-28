package lotto.ui

import lotto.util.Constants

class InputValidation {
    companion object{
        fun validatePurchaseAmount(input: String): Int {
            val amount = input.toIntOrNull()
                ?: throw IllegalArgumentException(Constants.ERROR_INVALID_NUMBER)

            if (amount < Constants.MIN_PURCHASE_AMOUNT) {
                throw IllegalArgumentException(Constants.ERROR_INVALID_PURCHASE_AMOUNT)
            }
            if (amount % Constants.PURCHASE_AMOUNT_UNIT != 0) {
                throw IllegalArgumentException(Constants.ERROR_INVALID_PURCHASE_UNIT)
            }
            return amount
        }
        fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
            val number = input.toIntOrNull()
                ?: throw IllegalArgumentException(Constants.ERROR_INVALID_BONUS_NUMBER)
            if (number !in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER) {
                throw IllegalArgumentException(Constants.ERROR_BONUS_OUT_OF_RANGE)
            }
            if (number in winningNumbers) {
                throw IllegalArgumentException(Constants.ERROR_DUPLICATE_BONUS_NUMBER)
            }
            return number
        }
    }
}