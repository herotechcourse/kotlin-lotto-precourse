package lotto.exception

enum class ExceptionMessage(val message: String) {
    INVALID_LOTTO_SIZE("[ERROR] Lotto must contain exactly 6 numbers."),
    INVALID_LOTTO_RANGE("[ERROR] Lotto numbers must be between 1 and 45."),
    DUPLICATE_LOTTO_NUMBERS("[ERROR] Lotto numbers must be unique."),
}