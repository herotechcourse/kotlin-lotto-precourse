package lotto.constants

enum class ErrorMessage(val message: String) {
    INPUT_IS_BLANK("[ERROR] The purchase amount can't be a null."),
    NOT_A_NUMBER("[ERROR] The purchase amount must be a number."),
    NOT_DIVISIBLE_BY_UNIT("[ERROR] The amount must be a multiple of the ticket price.")
}

enum class InputMessage(val message: String) {
    PURCHASE("Please enter the purchase amount.")
}