package lotto.view

object InputValidator {
    fun validatePurchaseAmount(input: String): Int{
        val purchaseAmount = parseAndValidateNumber(input)
        return purchaseAmount
    }

    private fun parseAndValidateNumber(input: String): Int {
        try {
            return input.toInt()
        }catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] This input must be a number.")
        }
    }
}