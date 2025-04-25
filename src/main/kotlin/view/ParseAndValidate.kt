package view

object ParseAndValidate {
    fun purchaseAmount(input: String): Int {
        val amount = input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be numeric.")
        require(amount > 0 && amount % 1000 == 0) { "[ERROR] Amount must be a positive multiple of 1,000." }
        return amount
    }
}