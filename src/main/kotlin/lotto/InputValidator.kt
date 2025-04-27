package lotto

object InputValidator {
    fun validatePurchaseAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6 || numbers.any { it !in 1..45 } || numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
        }
    }

    fun validateBonusNumber(bonus: Int, winningNumbers: Set<Int>) {
        if (bonus !in 1..45 || bonus in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45 and not duplicated.")
        }
    }

}