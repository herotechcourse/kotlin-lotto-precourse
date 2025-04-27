package lotto.validators

enum class ValidationErrors(val message: String) {
    MUST_DIVIDE_BY_TICKET_PRICE("A purchase amount must be divisible by 1,000"),
    MUST_BE_IN_RANGE("A number must be between 1 and 45."),
    MUST_ENTER_SIX_NUMBERS("You need to write 6 comma-separated numbers"),
    MUST_ENTER_UNIQUE_NUMBERS("You need to write 6 unique numbers"),
}
