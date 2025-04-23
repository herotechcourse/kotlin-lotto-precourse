package lotto

object InputValidator {
    /**
     * Validates the purchase amount to be >= 1000 and divisible by 1000.
     */
    fun validatePurchaseAmount(amount: Int) {
        if (amount < 1000) throw IllegalArgumentException("Amount must be at least 1000.")
        if (amount % 1000 != 0) throw IllegalArgumentException("Amount must be divisible by 1000.")
    }
}
