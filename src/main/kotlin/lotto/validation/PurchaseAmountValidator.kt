package lotto.validation

import lotto.validation.ErrorMessage

object PurchaseAmountValidator {
    private const val ERROR_PREFIX: String = "[ERROR]"
    private const val PROMPT_AGAIN: String = "Please enter it again"

    private const val AMOUNT_BELOW_MINIMUM = "$ERROR_PREFIX Amount must be at least 1000. $PROMPT_AGAIN"
    private const val NOT_DIVISIBLE_BY_UNIT = "$ERROR_PREFIX Amount  must be in units of 1,000. $PROMPT_AGAIN"

    fun validate(purchaseAmount: String) {
        require(purchaseAmount.isNotBlank()) { ErrorMessage.EMPTY_INPUT.message }
        require(purchaseAmount.matches("\\d+".toRegex())) { ErrorMessage.NOT_NUMBER_TYPE.message }
        require(purchaseAmount.toInt() >= 1000) { AMOUNT_BELOW_MINIMUM }
        require((purchaseAmount.toInt() % 1000) == 0) { NOT_DIVISIBLE_BY_UNIT }
    }
}
