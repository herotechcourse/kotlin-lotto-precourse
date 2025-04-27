package lotto.business

enum class LottoErrorMessage(private val errorMessage: String) {
    PURCHASE_AMOUNT_NOT_INTEGER("The purchase amount must be an integer."),
    INVALID_PURCHASE_AMOUNT_UNIT("Purchase amount must be a positive integer and a multiple of 1000."),

    LOTTO_NUMBER_DUPLICATED("Lotto numbers cannot be duplicated"),
    INVALID_LOTTO_NUMBER_RANGE("Lotto numbers must be between 1 and 45."),
    INVALID_LOTTO_NUMBER_SIZE("Lotto must contain exactly 6 numbers."),

    WINNING_NUMBER_NOT_INTEGER("Winning numbers must be an integer."),
    WINNING_NUMBER_DUPLICATED("Winning numbers cannot be duplicated"),
    INVALID_WINNING_NUMBER_RANGE("Winning numbers must be between 1 and 45."),
    INVALID_WINNING_NUMBER_SIZE("Winning numbers must contain exactly 6 numbers."),
    ;

    val message: String
        get() = "[ERROR] $errorMessage"
}