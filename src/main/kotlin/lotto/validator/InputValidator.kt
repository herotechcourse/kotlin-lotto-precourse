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

    fun allAreNumbers(input: List<String>) {
        input.forEach {
            isNumeric(it)
        }
    }

    fun numberCountIsSix(input: List<String>) {
        if (input.size != 6) {
            throw IllegalArgumentException("[ERROR] You must enter 6 numbers.")
        }
    }

    fun numberIsRange(input: String) {
        val number = input.toInt()
        if (number < 1 || number > 45) {
            throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        }
    }

    fun allNumbersInRange(input: List<String>) {
        input.forEach {
            numberIsRange(it)
        }
    }

    fun noDuplicateNumbers(input: List<String>) {
        val uniqueNumbers = input.toSet()
        if (uniqueNumbers.size != input.size) {
            throw IllegalArgumentException("[ERROR] Duplicate numbers are not allowed.")
        }
    }


}