package lotto.exception

/**
 * A sealed class representing various [LottoInputException]s for invalid inputs
 * related to lotto purchasing and winning number validations.
 *
 * This class extends [IllegalArgumentException] and prepends the error message with "[ERROR]".
 */
sealed class LottoInputException(message: String) : IllegalArgumentException("[ERROR] $message") {
    class InvalidPurchaseInput(input: String) :
        LottoInputException("Invalid input: '$input'. Please enter a positive number without any letters or symbols.")

    class InvalidAmount(amount: Int) :
        LottoInputException("Invalid amount: $amount. The purchase amount must be a positive number and divisible by 1,000 KRW.")

    class InvalidWinningNumbersInput(input: String) :
        LottoInputException("Invalid input: '$input'. Please enter 6 unique numbers separated by commas (e.g., 1,2,3,4,5,6).")

    class InvalidWinningNumbers(message: String) :
        LottoInputException("Invalid Winning Numbers: $message.")

    class InvalidBonusNumberInput(input: String) :
        LottoInputException("Invalid input: '$input'. Please enter a number in the range of 1 to 45 (inclusive), without any letters or special symbols.")

    class InvalidBonusNumber(bonusNumber: Int) :
        LottoInputException("Invalid bonus number: $bonusNumber. Please enter a number in the range of 1 to 45 (inclusive).")

    class InvalidBonusWithWinningNumbers(bonusNumber: Int) :
        LottoInputException("Invalid bonus number: $bonusNumber. Bonus number must not be one of the winning numbers.")
}