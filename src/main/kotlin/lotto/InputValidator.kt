package lotto

object InputValidator {
    /**
     * Validates the purchase amount to be >= 1000 and divisible by 1000.
     */
    fun validatePurchaseAmount(amount: Int) {
        if (amount < 1000) throw IllegalArgumentException("[ERROR] Amount must be at least 1000.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
    }

    /**
     * Parses a comma-separated string into a list of integers.
     * Throws if any value is not a valid integer.
     */
    fun parseWinningNumbers(input: String): List<Int> {
        return input.split(",").map {
            convertValidInteger(it)
        }
    }

    /**
     * Validates the winning numbers list.
     * Must contain exactly 6 distinct numbers between 1 and 45.
     */
    fun validateWinningNumbers(numbers: List<Int>): List<Int> {
        require(numbers.size == 6) { "[ERROR] Exactly 6 numbers must be entered." }
        require(numbers.distinct().size == 6) { "[ERROR] Numbers must be unique." }
        numbers.forEach { checkRange(it) }
        return numbers
    }

    /**
     * Validates that the bonus number is a valid integer in the range 1–45.
     */
    fun validateBonusNumber(input: String): Int {
        val number = convertValidInteger(input)
        checkRange(number)
        return number
    }

    /**
     * Checks that all numbers are within the valid range start to End inclusive.
     */
    private fun checkRange(number: Int) {
        require(number !in 1..45) { IllegalArgumentException("[ERROR] '${number}' must be between 1 and 45.") }
    }

    /**
     * Checks that all input is a Valid number
     */
    private fun convertValidInteger(input:String):Int{
        return input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    }
}
