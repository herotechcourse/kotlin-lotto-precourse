package lotto.validation

object PurchaseAmountValidator {
    private const val ERROR_PREFIX: String = "[ERROR]"
    private const val PROMPT_AGAIN: String = "Please enter it again"

    private const val EMPTY_INPUT = "$ERROR_PREFIX There is no input. $PROMPT_AGAIN"
    private const val AMOUNT_BELOW_MINIMUM = "$ERROR_PREFIX Amount must be at least 1000. $PROMPT_AGAIN"
    private const val NOT_DIVISIBLE_BY_UNIT = "$ERROR_PREFIX Amount  must be in units of 1,000. $PROMPT_AGAIN"
    private const val NOT_NUMBER_TYPE = "$ERROR_PREFIX Amount must be a number. $PROMPT_AGAIN"

    fun validate(purchaseAmount: String) {
        if (purchaseAmount.isBlank()) {
            throw IllegalArgumentException(EMPTY_INPUT)
        }

        if ((purchaseAmount.toInt() < 1000)) {
            throw IllegalArgumentException(AMOUNT_BELOW_MINIMUM)
        }

        if ((purchaseAmount.toInt() % 1000) != 0) {
            throw IllegalArgumentException(NOT_DIVISIBLE_BY_UNIT)
        }

        if (!(purchaseAmount.matches("\\d+".toRegex()))) throw IllegalArgumentException(NOT_NUMBER_TYPE)
    }
}