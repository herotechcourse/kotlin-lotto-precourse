package lotto.exception

enum class ExceptionMessage(val message: String) {
    INVALID_LOTTO_SIZE("[ERROR] Lotto must contain exactly 6 numbers."),
    INVALID_LOTTO_RANGE("[ERROR] Lotto numbers must be between 1 and 45."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] Lotto numbers must be unique."),
    INVALID_WINNING_LOTTO_SIZE("[ERROR] Winning lotto must contain exactly 6 numbers."),
    INVALID_BONUS_RANGE("[ERROR] Bonus number must be between 1 and 45."),
    BONUS_IN_WINNING_NUMBERS("[ERROR] Bonus number must not be in winning numbers."),
    DUPLICATE_WINNING_NUMBERS("[ERROR] Winning lotto numbers must be unique.");
}