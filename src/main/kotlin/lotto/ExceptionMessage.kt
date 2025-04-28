package lotto

enum class ExceptionMessage(val message: String) {
    INVALID_PURCHASE_AMOUNT("[ERROR] Purchase amount must be a multiple of 1000."),
    INVALID_PURCHASE_FORMAT("[ERROR] Purchase amount must be a number."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] Winning numbers must be valid integers."),
    INVALID_BONUS_FORMAT("[ERROR] Bonus number must be a valid integer."),
    INVALID_WINNING_LOTTO_SIZE("[ERROR] Winning lotto must contain exactly 6 numbers."),
    INVALID_BONUS_RANGE("[ERROR] Bonus number must be between 1 and 45."),
    INVALID_LOTTO_SIZE("ERROR] Lotto must contain exactly 6 numbers."),
    INVALID_LOTTO_RANGE("[ERROR] Lotto numbers must be between 1 and 45."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] Lotto numbers must be unique."),

}