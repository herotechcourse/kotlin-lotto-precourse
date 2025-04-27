package lotto

object InputValidator {
    fun validatePurchaseAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        }
    }

}