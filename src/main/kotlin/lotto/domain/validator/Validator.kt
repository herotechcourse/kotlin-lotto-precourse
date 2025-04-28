package lotto.domain.validator

import lotto.constants.ErrorMessage
import lotto.constants.LottoConstants

object Validator {
    fun <T> validateCount(input: List<T>) {
        if (input.size != LottoConstants.LOTTO_SIZE) {
            throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.message)
        }
    }

    fun <T> validateDuplication(input: List<T>) {
        val set = input.toSet()
        if (set.size != LottoConstants.LOTTO_SIZE) {
            throw IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.message)
        }
    }

    fun validateRange(number: Int) {
        if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
            throw IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.message)
        }
    }

    fun validateDuplicateOfBonusNumber(bonusNumber: Int, winningNumbers: Set<Int>) {
        if (winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.message)
        }
    }
}