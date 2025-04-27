package lotto

class LottoValidator {
    fun validatePurchaseAmount(amount: String) {
        validateIsNumeric(amount)
        validateIsPositive(amount)
        validateIsDivisibleBy1000(amount)
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
}