package lotto.error

enum class ExceptionMessage(val errorMessage: String) {
    DUPLICATE_LOTTO_NUMBER("[ERROR] Lotto numbers must consist of unique numbers."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] Lotto numbers must be between 1 and 45"),
    INVALID_LOTTO_NUMBER_SIZE("[ERROR] Lotto must contain exactly 6 numbers."),
    INPUT_IS_NOT_A_NUMBER("[ERROR] Input must be a number"),
    INVALID_PURCHASE_AMOUNT("[ERROR] Purchase amount must be in units of 1,000 KRW"),
    INVALID_BONUS_NUMBER("[ERROR] Bonus number must not be duplicated with winning lotto numbers")
}