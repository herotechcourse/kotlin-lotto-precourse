package lotto.exception

sealed class InputException(message: String) : IllegalArgumentException(message) {
    class InvalidInteger : InputException("[ERROR] Please input only numbers.")
    class AmountTooSmall : InputException("[ERROR] Amount must be at least 1,000.")
    class AmountNotDivisible : InputException("[ERROR] Amount must be a multiple of 1,000.")
    class InvalidWinningNumbers : InputException("[ERROR] Winning numbers must be exactly 6 unique numbers.")
    class NumberOutOfRange : InputException("[ERROR] Numbers must be between 1 and 45.")
}