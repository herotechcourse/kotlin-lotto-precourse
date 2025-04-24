package lotto.view

object InputValidator {
    private const val MAXIMUM_AMOUNT = 100_000
    private const val PURCHASE_UNIT = 1_000

    fun validatePurchaseAmount(input: String): Int{
        val purchaseAmount = parseAndValidateNumber(input)
        validateAmountRange(purchaseAmount)
        validatePurchasableUnit(purchaseAmount)
        return purchaseAmount
    }

    private fun parseAndValidateNumber(input: String): Int {
        try {
            return input.toInt()
        }catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] This input must be a number.")
        }
    }

    private fun validateAmountRange(amount: Int){
        require(amount <= MAXIMUM_AMOUNT) {"[ERROR] Amount must not exceed 100,000"}
    }

    private fun validatePurchasableUnit(amount: Int) {
        require(amount % PURCHASE_UNIT == 0) {"[ERROR] Purchase amount must entered as purchasable unit "}
    }
}