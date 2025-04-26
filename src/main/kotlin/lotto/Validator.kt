package lotto

class Validator {
    fun isPurchaseAmountValid(purchaseAmount: String): Int {
        val number = purchaseAmount.toIntOrNull() ?:
        throw IllegalArgumentException("The purchase amount must be a number.")
        if (number < 0 ) {
            throw IllegalArgumentException("The purchase amount must be a positive number.")
        }
        if (number % 1000 != 0) {
            throw IllegalArgumentException("The purchase amount must be divisible by 1000.")
        }
        return number
    }
}