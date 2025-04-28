package lotto.domain

object ErrorMessages {
    const val INVALID_PURCHASE_UNIT = "[ERROR] Purchase amount must be in multiples of 1,000 KRW."
    const val INVALID_WINNING_NUMBERS_SIZE = "[ERROR] Winning numbers must contain 6 numbers."
    const val INVALID_NUMBERS_RANGE = "[ERROR] Lotto number(s) must be between 1 and 45."
    const val INVALID_WINNING_NUMBERS_DUPLICATED = "[ERROR] Winning numbers contain duplicates."
    const val INVALID_BONUS_NUMBER_DUPLICATED = "[ERROR] Bonus number duplicates a winning number."
}
