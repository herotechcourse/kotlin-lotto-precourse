package lotto.messages

enum class PurchaseErrorMessage(val message: String) {
    NOT_A_NUMBER("The input is not a valid number."),
    NEGATIVE_NUMBER("Negative numbers are not allowed."),
    LESS_THAN_MINIMUM("Minimum amount is ₩1,000 per ticket."),
    NOT_A_MULTIPLE_OF_1000("Amount must be a multiple of ₩1,000.")
}