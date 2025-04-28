package lotto.utils

import lotto.Lotto
import lotto.utils.Constant.DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE
import lotto.utils.Constant.AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE
import lotto.utils.Constant.INVALID_BONUS_NUMERIC_ERROR_MESSAGE
import lotto.utils.Constant.INVALID_WINNING_NUMERIC_ERROR_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE
import lotto.utils.Constant.WINNING_NUMBER_RANGE_ERROR_MESSAGE
import lotto.utils.Constant.LOTTO_COST
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER

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

    fun validateWinningNumbers(winningNumber: List<String>): Result<Lotto> {
        return runCatching {
            Lotto(winningNumber.map {
                val intValue = it.toInt()
                require(intValue in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { WINNING_NUMBER_RANGE_ERROR_MESSAGE }
                intValue
            })
        }.recoverCatching { e ->
            when (e) {
                is NumberFormatException -> throw NumberFormatException(INVALID_WINNING_NUMERIC_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }

    fun validateBonusNumber(winningNumber: Lotto, bonusNumber: String): Result<Int> {
        return runCatching {
            val intValue = bonusNumber.toInt()
            require(intValue !in winningNumber.getNumbers()) { DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE }
            require(intValue in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { WINNING_NUMBER_RANGE_ERROR_MESSAGE }
            intValue
        }.recoverCatching { e ->
            when (e) {
                is NumberFormatException -> throw NumberFormatException(INVALID_BONUS_NUMERIC_ERROR_MESSAGE)
                else -> throw e
            }
        }
    }
}