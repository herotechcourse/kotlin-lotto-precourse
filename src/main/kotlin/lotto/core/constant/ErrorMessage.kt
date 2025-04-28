package lotto.core.constant

import lotto.core.constant.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.core.constant.LottoConstants.MAX_LOTTO_NUMBER
import lotto.core.constant.LottoConstants.MIN_LOTTO_NUMBER

object ErrorMessage {
    object ErrorMessages {
        const val NOT_A_NUMBER_ERROR = "[ERROR] Please enter a valid number."
        const val NOT_A_POSITIVE_NUMBER_ERROR = "[ERROR] Amount must be greater than 0."
        const val LOTTO_NUMBER_SIZE_ERROR = "[ERROR] Exactly $LOTTO_NUMBER_SIZE winning numbers must be provided."
        const val LOTTO_UNIQUE_NUMBER_ERROR = "[ERROR] Winning numbers must be unique."
        const val LOTTO_BONUS_NUMBER_RANGE_ERROR =
            "[ERROR] Bonus number must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."
        const val LOTTO_BONUS_NUMBER_ERROR =
            "[ERROR] Please enter a valid number."
        const val LOTTO_WINING_NUMBER_RANGE_ERROR =
            "[ERROR] Winning numbers must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."
        const val LOTTO_WINING_NUMBER__ERROR =
            "ERROR] Please enter valid numbers separated by commas."
        const val NOT_DIVISIBLE_BY_1000_ERROR = "[ERROR] Amount must be divided by 1000."
    }
}