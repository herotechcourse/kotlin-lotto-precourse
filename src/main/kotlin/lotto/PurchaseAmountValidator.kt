package lotto

class PurchaseAmountValidator {
    fun validatePurchaseAmount(purchaseAmount: Int?) {
        if (purchaseAmount == null || purchaseAmount % 1000 != 0 || purchaseAmount <= 0) {
            throw IllegalArgumentException("[ERROR] Invalid purchase amount. " +
                    "Input must be greater than zero and divisible by 1,000")
        }
    }
}