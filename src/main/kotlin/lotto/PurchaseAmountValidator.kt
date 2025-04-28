package lotto

object PurchaseAmountValidator {
    fun validate(input: String) {
        val cleanedInput = input.replace(",", "").trim()
        require(cleanedInput.isNotBlank()) { "[ERROR] Purchase amount cannot be blank." }

        val purchaseAmount = cleanedInput.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Purchase amount must be an integer without decimal points.")

        require(purchaseAmount >= 1000) { "[ERROR] Purchase amount must be at least 1,000 KRW." }
        require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
    }
}