package lotto.util

import lotto.util.Rule
import lotto.exception.ExceptionMessage

object Validator {
    fun validatePurchaseAmount(amount: Int) {
        validateMinimumPurchaseAmount(amount)
        validateDivisibleByLottoPrice(amount)
    }

    fun validateLottoNumbers(numbers: List<Int>) {
        validateNumberCount(numbers)
        validateNumberRange(numbers)
        validateUniqueNumbers(numbers)
    }

    fun validateBonusNumber(bonus: Int, winningNumber: List<Int>) {
        validateBonusNumberRange(bonus)
        validateBonusNumberNotInWinningNumbers(bonus, winningNumber)
    }

    private fun validateMinimumPurchaseAmount(amount: Int) {
        require(amount >= Rule.LOTTO_PRICE) {
            ExceptionMessage.INSUFFICIENT_PURCHASE_AMOUNT.message
        }
    }
    private fun validateDivisibleByLottoPrice(amount: Int) {
        require(amount % Rule.LOTTO_PRICE == 0) {
            ExceptionMessage.INVALID_PURCHASE_AMOUNT_FORMAT.message
        }
    }

    private fun validateNumberCount(numbers: List<Int>) {
        require(numbers.size == Rule.NUMBERS_COUNT) {
            ExceptionMessage.INVALID_NUMBER_COUNT.message
        }
    }

    private fun validateNumberRange(numbers: List<Int>) {
        require(numbers.all { it in Rule.MIN_NUMBER..Rule.MAX_NUMBER }) {
            ExceptionMessage.OUT_OF_RANGE_NUMBER.message
        }
    }

    private fun validateUniqueNumbers(numbers: List<Int>) {
        require(numbers.toSet().size == Rule.NUMBERS_COUNT) {
            ExceptionMessage.DUPLICATE_NUMBERS.message
        }
    }

    private fun validateBonusNumberRange(bonus: Int) {
        require(bonus in Rule.MIN_NUMBER..Rule.MAX_NUMBER) {
            ExceptionMessage.INVALID_BONUS_NUMBER_RANGE.message
        }
    }

    private fun validateBonusNumberNotInWinningNumbers(bonus: Int, winningNumbers: List<Int>) {
        require(bonus !in winningNumbers) {
            ExceptionMessage.DUPLICATE_BONUS_NUMBER.message
        }
    }
}