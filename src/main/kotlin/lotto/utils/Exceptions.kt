package lotto.utils

import lotto.utils.Constant.AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE
import lotto.utils.Constant.LOTTO_COST

object Exceptions {
    fun validatePurchaseAmount(purchaseAmount: String): Result<Int> {
        return runCatching {
            val intValue = purchaseAmount.toInt()
            require(intValue % LOTTO_COST == 0) { AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE }
            intValue
        }.recoverCatching { e ->
            when (e) {
                is NumberFormatException -> throw NumberFormatException(PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }
}