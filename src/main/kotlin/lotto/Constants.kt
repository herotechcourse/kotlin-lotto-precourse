package lotto

object Constants {
    const val LOTTO_NUMBER_COUNT = 6
    const val MIN_NUMBER = 1
    const val MAX_NUMBER = 45
    const val TICKET_PRICE = 1000

    const val FIRST_PRIZE = 2_000_000_000
    const val SECOND_PRIZE = 30_000_000
    const val THIRD_PRIZE = 1_500_000
    const val FOURTH_PRIZE = 50_000
    const val FIFTH_PRIZE = 5_000

    const val ERROR_INVALID_AMOUNT = "[ERROR] Amount must be at least $TICKET_PRICE and divisible by $TICKET_PRICE."
    const val ERROR_INVALID_NUMBER = "[ERROR] Please enter a valid number."
    const val ERROR_INVALID_WINNING_NUMBERS =
        "[ERROR] Winning numbers must contain exactly $LOTTO_NUMBER_COUNT numbers."
    const val ERROR_INVALID_BONUS_NUMBER = "[ERROR] Bonus number must be between $MIN_NUMBER and $MAX_NUMBER."
    const val ERROR_WINNING_NUMBERS_UNIQUE = "[ERROR] Winning numbers must be unique."
    const val ERROR_LOTTO_NUMBERS_UNIQUE = "[ERROR] Lotto numbers must be unique."
    const val ERROR_INVALID_NUMBERS = "[ERROR] Please enter valid numbers separated by commas."
    const val ERROR_BONUS_NOT_IN_WINNING = "[ERROR] Bonus number must not be among winning numbers."
    const val ERROR_INVALID_LOTTO_COUNT = "[ERROR] Lotto must contain exactly $LOTTO_NUMBER_COUNT numbers."
    const val ERROR_LOTTO_BETWEEN = "[ERROR] Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER."
    const val ERROR_WINNING_NUMBERS = "[ERROR] Winning numbers must be between 1 and 45."
}