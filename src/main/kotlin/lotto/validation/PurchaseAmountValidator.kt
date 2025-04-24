package lotto.validation

class PurchaseAmountValidator {

    // Validate if the input is a number and return the integer value
    fun validateIsNumber(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] The input must be a valid number.")
        return amount
    }

    // Validate if the number is divisible by 1000
    fun validateIsDivisibleByThousand(amount: Int): Boolean {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] The purchase amount must be divisible by 1000.")
        }

        return true
    }

    // Validate the purchase amount (uses both validation methods)
    fun validatePurchaseAmount(input: String): Int {
        val amount = validateIsNumber(input)
        validateIsDivisibleByThousand(amount)
        return amount
    }
}