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

    fun checkLottoSize(input: List<Int>) {
        require(input.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun numberIsRange(input: Int) {
        require(input in 1..45) { "Numbers must be between 1 and 45." }
    }

    fun allNumbersInRange(input: List<Int>) {
        input.forEach {
            numberIsRange(it)
        }
    }

    fun noDuplicateNumbers(input: List<Int>) {
        val uniqueNumbers = input.toSet()
        if (uniqueNumbers.size != input.size) {
            throw IllegalArgumentException("[ERROR] Duplicate numbers are not allowed.")
        }
    }

}