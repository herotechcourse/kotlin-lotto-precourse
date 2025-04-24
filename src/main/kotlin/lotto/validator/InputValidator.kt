package lotto.validator

object InputValidator {
    private const val THRESHOLD_UNIT = 1000

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

    fun isMultipleOfThousand(input: Int) {
        if (input % THRESHOLD_UNIT != 0) {
            throw IllegalArgumentException("[ERROR] Input must be a multiple of $THRESHOLD_UNIT.")
        }
    }

    fun allAreNumbers(inputs: List<String>) {
        inputs.forEach {
            isNumeric(it)
        }
    }
}