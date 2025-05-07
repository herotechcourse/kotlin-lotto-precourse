package lotto

class LottoValidator {
    fun validatePurchaseAmount(amount: String) {
        validateIsNumeric(amount)
        validateIsPositive(amount)
        validateIsDivisibleBy1000(amount)
    }

    fun validateWinningNumbers(winningNumbers: List<String>) {
        validateAllNumbersAreNumeric(winningNumbers)
    }

    fun validateBonusNumber(bonusNumber: String, winningNumbers: Lotto) {
        validateIsNumeric(bonusNumber)
        validateRange1to45(bonusNumber)
        validateNoDuplicatesForBonus(bonusNumber, winningNumbers)
    }

    private fun validateIsNumeric(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] Input must be a number.")
        }
    }

    private fun validateIsPositive(amount: String) {
        if (amount.toInt() <= 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
        }
    }

    private fun validateIsDivisibleBy1000(amount: String) {
        if (amount.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
        }
    }

    private fun validateAllNumbersAreNumeric(winningNumbers: List<String>) {
        if (winningNumbers.any { it.toIntOrNull() == null }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be numbers.")
        }
    }

    private fun validateRange1to45(bonusNumber: String) {
        if (bonusNumber.toInt() !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be in the range of 1 to 45.")
        }
    }

    private fun validateNoDuplicatesForBonus(bonusNumber: String, winningNumbers: Lotto) {
        if (winningNumbers.contains(bonusNumber.toInt())) {
            throw IllegalArgumentException("[ERROR] Bonus number must be not contain in winning numbers.")
        }
    }
}