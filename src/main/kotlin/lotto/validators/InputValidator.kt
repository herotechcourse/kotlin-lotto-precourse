package lotto.validators

import lotto.constants.TICKET_PRICE

object InputValidator {
    fun validateSumOfMoney(sum: Int?): Int {
        requireNotNull(sum) { ValidationErrors.MUST_BE_INTEGER.message }

        require(sum % TICKET_PRICE == 0 && sum != 0) { ValidationErrors.MUST_DIVIDE_BY_TICKET_PRICE.message }

        return sum
    }

    fun validateNumberInRange(number: Int?): Int {
        requireNotNull(number) { ValidationErrors.MUST_BE_INTEGER.message }

        require(number in 1..45) {
            ValidationErrors.MUST_BE_IN_RANGE.message
        }

        return number
    }

    fun validateNumbers(numbers: List<Int?>): List<Int> {
        require(numbers.size == 6) {
            ValidationErrors.MUST_ENTER_SIX_NUMBERS.message
        }

        require(numbers.all { it != null }) { ValidationErrors.MUST_BE_INTEGER.message }

        require(numbers.size == numbers.toSet().size) {
            ValidationErrors.MUST_ENTER_UNIQUE_NUMBERS.message
        }

        return numbers.map { it -> validateNumberInRange(it) }
    }
}
