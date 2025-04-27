package lotto.validators

object InputValidator {
    fun validateSumOfMoney(sum: Int) {
        if (sum < 1000) {
            throw IllegalArgumentException(ValidationErrors.MUST_DIVIDE_BY_TICKET_PRICE.message)
        }

    }

    fun validateNumberInRange(number: Number) {
        if (number !in 1..45) {
            throw IllegalArgumentException(ValidationErrors.MUST_BE_IN_RANGE.message)
        }
    }

    fun validateNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ValidationErrors.MUST_ENTER_SIX_NUMBERS.message)
        }
        if (numbers.size != numbers.toSet().size) {
            throw IllegalArgumentException(ValidationErrors.MUST_ENTER_UNIQUE_NUMBERS.message)
        }
        for (number in numbers) {
            validateNumberInRange(number)
        }
    }
}
