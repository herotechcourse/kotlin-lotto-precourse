package lotto.exception

sealed class WinningNumbersException(message: String) : IllegalArgumentException(message) {
    class InvalidCount : WinningNumbersException("[ERROR] Winning numbers must contain exactly 6 numbers.")
    class BonusDuplicate : WinningNumbersException("[ERROR] Bonus number must not duplicate winning numbers.")
}
