package lotto.validators

object InputValidator {
    fun validateSumOfMoney(sum: Int?): Int {
        requireNotNull(sum) { "[ERROR] The purchase amount should be an integer." }

        require(sum >= 1000) { ValidationErrors.MUST_DIVIDE_BY_TICKET_PRICE.message }

        return sum
    }

    fun validateNumberInRange(number: Int?): Int {
        requireNotNull(number) { "[ERROR] A number should be an integer." }

        require(number in 1..45) {
            ValidationErrors.MUST_BE_IN_RANGE.message
        }

        return number
    }

    fun validateNumbers(numbers: List<Int?>): List<Int> {
        require(numbers.size == 6) {
            ValidationErrors.MUST_ENTER_SIX_NUMBERS.message
        }

        require(numbers.all { it != null }) { "[ERROR] The winning number should be an integer." }

        require(numbers.size == numbers.toSet().size) {
            ValidationErrors.MUST_ENTER_UNIQUE_NUMBERS.message
        }

        return numbers.map { it -> validateNumberInRange(it) }
    }
}
