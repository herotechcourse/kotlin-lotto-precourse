package lotto

enum class LottoErrorEnum(val message: String) {
    NULL_WINNING_NUMBER("[ERROR] Lotto numbers must be integer."),
    NULL_BONUS_NUMBER("[ERROR] Lotto number must be integer."),
    INVALID_SIZE("[ERROR] Lotto must contain exactly 6 numbers."),
    NUMBER_OUT_OF_RANGE("[ERROR] Lotto numbers must be between 1 and 45."),
    DUPLICATED_NUMBER("[ERROR] Lotto numbers must be unique."),
    DIVISIBLE_AMOUNT("[ERROR] Amount must be divisible by 1,000 KRW."),
}