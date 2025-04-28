package lotto.exception

enum class InputException(private val message: String) : ErrorCode {
    INVALID_INTEGER("[ERROR] Please input only numbers."),
    AMOUNT_TOO_SMALL("[ERROR] Amount must be at least 1,000."),
    AMOUNT_NOT_DIVISIBLE("[ERROR] Amount must be a multiple of 1,000."),
    INVALID_WINNING_NUMBERS("[ERROR] Winning numbers must be exactly 6 unique numbers."),
    NUMBER_OUT_OF_RANGE("[ERROR] Numbers must be between 1 and 45.");

    override fun getMessage(): String = message
}