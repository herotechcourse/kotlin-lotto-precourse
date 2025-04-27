package lotto.exception

enum class WinningNumbersException(private val message: String) : ErrorCode {
    INVALID_WINNING_NUMBERS("[ERROR] Winning numbers must contain exactly 6 numbers."),
    BONUS_DUPLICATE("[ERROR] Bonus number must not duplicate winning numbers.");

    override fun getMessage(): String = message
}