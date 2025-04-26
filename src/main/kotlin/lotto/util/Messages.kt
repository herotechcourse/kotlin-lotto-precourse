package lotto.util

object Messages {

    object Prompt {
        const val PURCHASE_AMOUNT = "Please enter the purchase amount (must be multiple of ${Config.TICKET_PRICE}; for example ${Config.TICKET_PRICE * 2}):"
        const val WINNING_NUMBERS = "Enter the ${Config.LOTTO_NUMBER_COUNT} winning numbers (comma-separated):"
        const val BONUS_NUMBER    = "Enter the bonus number:"
    }


    object Error {
        const val NOT_A_NUMBER                       = "[ERROR] Invalid input: '%s' is not a number."
        const val NOT_MULTIPLE_OF_TICKET_PRICE       = "[ERROR] Purchase amount must be a multiple of ${Config.TICKET_PRICE} KRW. Received: %d"
        const val INVALID_BONUS_NUMBER               = "[ERROR] Bonus number must be between ${Config.LOTTO_MIN_NUMBER} and ${Config.LOTTO_MAX_NUMBER}. Received: %d"
        const val OUT_OF_RANGE                       = "[ERROR] Winning numbers must consist of ${Config.LOTTO_NUMBER_COUNT} unique numbers from ${Config.LOTTO_MIN_NUMBER} to ${Config.LOTTO_MAX_NUMBER}. Received: %s"
        const val MALFORMED_LIST                     = "[ERROR] '%s' is not valid. Please use commas like: 1,2,3,4,5,6"
        const val EMPTY_VALUE_AT                     = "[ERROR] Empty value at position %d. Please check your commas."
        const val INVALID_INTEGER                    = "[ERROR] '%s' is not a valid integer."
        const val INPUT_DOES_NOT_MEET_CRITERIA       = "[ERROR] Input does not meet criteria."
        const val NUMBERS_NOT_UNIQUE                 = "[ERROR] Winning numbers must be unique."
        const val BONUS_DUPLICATE                    = "[ERROR] Bonus number must not duplicate any winning number."
    }
}