package lotto.validator

object InputValidator {
    fun notEmpty(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.")
        }
    }

    fun isNumeric(input: String) {
        if (!input.all { it.isDigit() }) {
            throw IllegalArgumentException("[ERROR] Input must be a number.")
        }
    }

    fun withinRange(input: Int, minRange: Int, maxRange: Int) {
        if (input < minRange || input > maxRange) {
            throw IllegalArgumentException("[ERROR] Input must be a number between $minRange and $maxRange.")
        }
    }
}