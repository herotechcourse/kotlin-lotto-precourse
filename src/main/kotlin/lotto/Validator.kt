package lotto

class Validator {
    companion object {
        fun validatePurchaseAmount(input: String): Int {
            return input.toIntOrNull()?.also {
                require(it > 0) { "[ERROR] Purchase amount must be positive." }
                require(it % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
            } ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }

        fun validateBonusNumber(input: String, winningNumbers: Lotto): Int {
            return input.toIntOrNull()?.also {
                require(it in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
                require(!winningNumbers.contains(it)) { "[ERROR] Bonus number must not be among the winning numbers." }
            } ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }

        fun validateWinningNumbers(input: String): Lotto {
            try {
                val numbers = input.split(",").map { it.trim().toInt() }
                return Lotto(numbers)
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.")
            }
        }
    }
}