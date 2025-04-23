package lotto.validator

object InputValidator {
    fun notEmpty(input: String?) {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.")
        }
    }
}