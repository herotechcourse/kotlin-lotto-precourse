package lotto.validation

class WinningNumberValidator {

    // Check if input is not blank
    fun isNotBlank(input: String): Boolean {
        if (input.isBlank()) {
            throw IllegalArgumentException("[ERROR] The input cannot be blank.")
        }
        return true
    }

    // Validate if the input contains a comma separator
    fun containsCommaSeparator(input: String): Boolean {

        isNotBlank(input) // Ensure the input is not blank

        if (!input.contains(",")) {
            throw IllegalArgumentException("[ERROR] The input must contain a comma as a separator.")
        }
        return true
    }

    // Validate if the input is a number and return the integer value
    fun validateIsNumber(input: String): Int {

        isNotBlank(input) // Ensure the input is not blank

        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] The input must be a valid number.")
    }
}