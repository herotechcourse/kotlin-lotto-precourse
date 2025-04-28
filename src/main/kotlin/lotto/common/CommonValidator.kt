package lotto.common

object CommonValidator {
    fun parseAndValidateNumber(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] This input must be a number.")
        }
    }
}