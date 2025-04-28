package lotto

object InputValidator {

    fun validatePurchaseAmount(input: Int): Int {
        if (input <= 0 || input % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] The purchase amount must be divisible by 1,000")
        }
        return input
    }
}
