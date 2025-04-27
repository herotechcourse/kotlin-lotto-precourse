package lotto.utils

object Validator {

    fun validateNumber(input: String) {
        require(input.isNotBlank()) {
            "[ERROR] Input must not be blank."
        }
        require(input.toIntOrNull() != null) {
            "[ERROR] Input must be a valid number."
        }
        require(input.toInt() > 0) {
            "[ERROR] Number must be greater than 0."
        }
    }

    fun validatePurchaseAmount(input: String) {
        validateNumber(input)
        val amount = input.toInt()
        require(amount >= 1000) {
            "[ERROR] Purchase amount must be at least 1,000."
        }
        require(amount % 1000 == 0) {
            "[ERROR] Purchase amount must be divisible by 1,000."
        }
    }

    fun validateNumberListSize(numbers: List<String>, expectedSize: Int = 6) {
        require(numbers.size == expectedSize) {
            "[ERROR] You must enter exactly $expectedSize numbers."
        }
    }

    fun validateAllNumbers(numbers: List<String>) {
        numbers.forEach { validateNumber(it) }
    }
}
