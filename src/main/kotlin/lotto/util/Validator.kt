package lotto.util

object Validator {

    fun validateNumber(input: String) {
        require(input.all { it.isDigit() }) {
            "[ERROR] Input must be a valid number."
        }

        require(input.toInt() > 0) {
            "[ERROR] Number must be greater than 0."
        }
    }

    fun validateNumberListSize(numbers: List<String>, expectedSize: Int = 6) {
        require(numbers.size == expectedSize) {
            "[ERROR] You must enter exactly $expectedSize numbers."
        }
    }

    fun validateAllNumbers(numbers: List<String>) {
        numbers.forEach { validateNumber(it) }
    }
}
