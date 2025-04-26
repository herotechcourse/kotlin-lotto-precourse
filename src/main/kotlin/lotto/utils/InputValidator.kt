package lotto.utils

interface InputValidator {
    fun validateInput(inputString: String): Int
}

class InputValidatorImpl : InputValidator {
    override fun validateInput(inputString: String): Int {
        try {
            val number = inputString.toInt()
            require(number > 0) { POSITIVE_INTEGER_ERROR_MESSAGE }
            require(number % DIVISOR == 0) { DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE }
            return number
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(POSITIVE_INTEGER_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val POSITIVE_INTEGER_ERROR_MESSAGE = "Amount must be an integer number greater than zero."
        private const val DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE = "Amount must be divisible by 1,000."
        private const val DIVISOR = 1000
    }
}