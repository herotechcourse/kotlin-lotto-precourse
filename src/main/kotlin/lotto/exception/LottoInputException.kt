package lotto.exception

sealed class LottoInputException(message: String): IllegalArgumentException("[ERROR] $message") {
    class InvalidInput(input: String): LottoInputException("Invalid input: '$input'. Please enter a positive number without any letters or symbols.")
    class InvalidAmount(amount: Int): LottoInputException("Invalid amount: $amount. The purchase amount must be a positive number and divisible by 1,000 KRW.")
}