package lotto

class Validator {
    companion object {
        fun validatePurchaseAmount(input: String): Int {
            try {
                val amount = input.toInt()
                require(amount > 0) { "[ERROR] Purchase amount must be positive." }
                require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
                return amount
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] Please enter a valid number.")
            }
        }

        fun validateWinningNumbers(input: String): Lotto {
            try {
                val numbers = input.split(",").map { it.trim().toInt() }
                return Lotto(numbers)
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.")
            }
        }

        fun validateBonusNumber(input: String, winningNumbers: Lotto): Int {
            try {
                val bonusNumber = input.toInt()
                require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
                require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number must not be among the winning numbers." }
                return bonusNumber
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("[ERROR] Please enter a valid number.")
            }
        }
    }
}