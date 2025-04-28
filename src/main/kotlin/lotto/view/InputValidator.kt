package lotto.view

import lotto.common.CommonValidator

object InputValidator {
    fun parseAndValidateNumber(input: String): Int {
        val purchaseAmount = CommonValidator.parseAndValidateNumber(input)
        return purchaseAmount
    }

    fun validateBlank(input: String): String {
        require(input.isNotBlank()) { "[ERROR] This input must not be blank." }
        return input
    }

    fun validateBlankAndParseNumber(input: String): Int {
        val bonusNumber = validateBlank(input)
        return CommonValidator.parseAndValidateNumber(bonusNumber)
    }
}