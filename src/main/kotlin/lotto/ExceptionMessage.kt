package lotto

enum class ExceptionMessage(errorMessage: String) {
    DUPLICATE_LOTTO_NUMBER("[ERROR] Lotto numbers must consist of unique numbers."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] Lotto numbers must in the range from 1 to 45"),
    INVALID_LOTTO_NUMBER_SIZE("[ERROR] Lotto must contain exactly 6 numbers.")
}