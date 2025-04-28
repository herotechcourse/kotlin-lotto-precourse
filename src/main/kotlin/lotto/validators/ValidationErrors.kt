package lotto.validators

enum class ValidationErrors(val message: String) {
    MUST_DIVIDE_BY_TICKET_PRICE("[ERROR] A purchase amount must be divisible by 1,000 and positive"),
    MUST_BE_IN_RANGE("[ERROR] A number must be between 1 and 45."),
    MUST_ENTER_SIX_NUMBERS("[ERROR] Lotto must contain exactly 6 numbers."),
    MUST_ENTER_UNIQUE_NUMBERS("[ERROR] You need to write 6 unique numbers"),
    MUST_BE_INTEGER("[ERROR] The purchase amount should be an integer.")
}
