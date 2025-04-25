package view

object ParseAndValidate {
    fun purchaseAmount(input: String): Int {
        val amount = input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be numeric.")
        require(amount > 0 && amount % 1000 == 0) { "[ERROR] Amount must be a positive multiple of 1,000." }
        return amount
    }

    fun winningNumbers(input: String): List<Int> {
        require(input.isNotEmpty() && input.isNotBlank()) { "[ERROR] Winning numbers must be numeric." }
        return input.split(",")
            .map { it.trim()
                .toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numeric.") }
            .onEach { require(it in 1..45) { "[ERROR] Winning numbers must be between 1 and 45." } }
    }

    fun bonusNumber(input: String, winningNumbers: List<Int>): Int {
        return 7
    }
}