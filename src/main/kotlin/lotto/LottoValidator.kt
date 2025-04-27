package lotto

class LottoValidator {
    fun validatePurchaseAmount(amount: String) {
        validateIsNumeric(amount)
        validateIsPositive(amount)
        validateIsDivisibleBy1000(amount)
    }

    fun validateWinningNumbers(winningNumbers: List<String>) {
        validateAllNumbersAreNumeric(winningNumbers)
        validateSizeIsSix(winningNumbers)
        validateRange1to45(winningNumbers)
        validateNoDuplicates(winningNumbers)
    }

    private fun validateIsNumeric(amount: String) {
        if (amount.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a number.")
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

    private fun validateSizeIsSix(winningNumbers: List<String>) {
        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers size should be 6.")
        }
    }

    private fun validateRange1to45(winningNumbers: List<String>) {
        if (winningNumbers.any { it.toInt() < 1 } || winningNumbers.any { it.toInt() > 45 }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be in the range of 1 to 45.")
        }
    }

    private fun validateNoDuplicates(winningNumbers: List<String>) {
        if (winningNumbers.distinct().size != winningNumbers.size) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
    }
}