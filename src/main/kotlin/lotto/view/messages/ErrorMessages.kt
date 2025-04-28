package lotto.view.messages

enum class PurchaseErrorMessage(val message: String) {
    NOT_A_NUMBER("The input is not a valid number."),
    NEGATIVE_NUMBER("Negative numbers are not allowed."),
    LESS_THAN_MINIMUM("Minimum amount is ₩1,000 per ticket."),
    NOT_A_MULTIPLE_OF_1000("Amount must be a multiple of ₩1,000.")
}

enum class WinningNumberErrorMessage(val message: String) {
    NOT_A_NUMBER("The input is not a valid number."),
    NOT_IN_RANGE("The number must be between 1 and 45."),
    DUPLICATE_NUMBER("Duplicate numbers are not allowed."),
    NOT_SIX_NUMBERS("Exactly 6 numbers must be entered."),
    BONUS_NUMBER_DUPLICATE("Bonus number must not be one of the winning numbers.")
}