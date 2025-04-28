package lotto.utils

object Validator {

    fun validateNumber(input: String) {
        require(input.isNotBlank()) {
            "[ERROR] Input must not be blank."
        }
        require(input.toIntOrNull() != null) {
            "[ERROR] Input must be a valid number."
        }
        require(input.toInt() >= Constants.MINIMUM_VALID_NUMBER) {
            "[ERROR] Number must be greater than or equal to ${Constants.MINIMUM_VALID_NUMBER}."
        }
    }

    fun validatePurchaseAmount(input: String) {
        validateNumber(input)
        val amount = input.toInt()
        require(amount >= Constants.MINIMUM_PURCHASE_AMOUNT) {
            "[ERROR] Purchase amount must be at least ${Constants.MINIMUM_PURCHASE_AMOUNT}."
        }
        require(amount % Constants.MINIMUM_PURCHASE_AMOUNT == 0) {
            "[ERROR] Purchase amount must be divisible by ${Constants.MINIMUM_PURCHASE_AMOUNT}."
        }
    }

    fun validateNumberListSize(numbers: List<String>, expectedSize: Int = Constants.LOTTO_NUMBER_COUNT) {
        require(numbers.size == expectedSize) {
            "[ERROR] You must enter exactly $expectedSize numbers."
        }
    }

    fun validateAllNumbers(numbers: List<String>) {
        numbers.forEach { validateNumber(it) }
    }
}