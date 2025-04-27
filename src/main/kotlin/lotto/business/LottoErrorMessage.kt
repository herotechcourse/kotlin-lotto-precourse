package lotto.business

enum class LottoErrorMessage(private val errorMessage: String) {
    PURCHASE_AMOUNT_NOT_INTEGER("The purchase amount must be an integer."),
    INVALID_PURCHASE_AMOUNT_UNIT("Purchase amount must be a positive integer and a multiple of 1000."),
    ;

    val message: String
        get() = "[ERROR] $errorMessage"
}