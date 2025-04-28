package lotto.validators

/**
 * Validator class to ensure the input string is comma-separated.
 */
class CommaSeparatedValidator : InputValidator<List<Int>> {
    /**
     * Validates the input string to ensure it is comma-separated.
     *
     * @param input The input string containing the winning numbers.
     * @return A list of integers representing the winning numbers.
     * @throws IllegalArgumentException if the input is not comma-separated.
     */
    override fun validate(input: String): List<Int> {
        if (!input.contains(",")) {
            throw IllegalArgumentException("[ERROR] Winning numbers should be comma-separated.")
        }

        return input.split(",").map {
            it.trim().toInt()
        }
    }
}
