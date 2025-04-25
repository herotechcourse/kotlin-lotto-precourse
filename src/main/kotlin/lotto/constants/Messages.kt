package lotto.constants

object Messages {

    object Prompt {
        const val PURCHASE_AMOUNT = "Please enter the purchase amount."
        const val WINNING_NUMBERS = "Please enter last week's winning numbers."
        const val BONUS_NUMBER = "Please enter the bonus number."
    }

    object Output {
        const val WINNING_STATISTICS_TITLE = "Winning Statistics\n---"
        const val PURCHASE_COUNT = "You have purchased %d tickets."
        const val PROFIT_RATE = "Total return rate is %.1f%%."
        const val LOTTO_RESULT_STATISTICS = "%s – %d tickets"
    }

    object Error {
        const val INPUT_NOT_EMPTY = "Input cannot be empty."
        const val INPUT_MUST_BE_NUMBER = "Input must be a number."
        const val INPUT_MUST_BE_IN_RANGE =
            "Purchase must be a number between ${Constants.MIN_PURCHASE_RANGE} and ${Constants.MAX_PURCHASE_RANGE}."
        const val INPUT_MUST_BE_MULTIPLE_OF_THOUSAND = "Input must be a multiple of ${Constants.LOTTO_PURCHASE_UNIT}."
        const val LOTTO_NUMBERS_COUNT = "Lotto must contain exactly ${Constants.LOTTO_NUMBERS_COUNT} numbers."
        const val LOTTO_NUMBERS_RANGE =
            "Numbers must be between ${Constants.LOTTO_MIN_NUMBER} and ${Constants.LOTTO_MAX_NUMBER}."
        const val DUPLICATE_NUMBERS = "Duplicate numbers are not allowed."
        const val DUPLICATE_BONUS_NUMBER = "Bonus number must not be in the main lotto numbers."

        const val FORMAT = "[ERROR] %s\n"
    }


}