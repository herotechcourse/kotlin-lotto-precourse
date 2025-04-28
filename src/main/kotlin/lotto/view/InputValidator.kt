package lotto.view

import lotto.common.CommonValidator
import lotto.exception.InputException

object InputValidator {
    fun parseAndValidateNumber(input: String): Int {
        val purchaseAmount = CommonValidator.parseAndValidateNumber(input)
        return purchaseAmount
    }

    fun validateBlank(input: String): String {
        require(input.isNotBlank()) { InputException.MUST_NOT_BE_BLANK.message() }
        return input
    }

    fun validateBlankAndParseNumber(input: String): Int {
        val bonusNumber = validateBlank(input)
        return CommonValidator.parseAndValidateNumber(bonusNumber)
    }
}