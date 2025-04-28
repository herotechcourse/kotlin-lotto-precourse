package lotto.util

object InputValidator {

    fun validatePurchaseAmount(input: Int): Int {
        if (input <= 0 || input % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] The purchase amount must be divisible by 1,000")
        }
        return input
    }

    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
        }
    }
}
