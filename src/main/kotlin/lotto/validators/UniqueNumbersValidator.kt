package lotto.validators

/** Validator class to ensure all numbers in the input are unique. */
class UniqueNumbersValidator : InputValidator<List<Int>> {
    /**
     * Validates that all numbers in the input list are unique.
     *
     * @param input The input string containing the numbers.
     * @return A list of integers if all numbers are unique.
     * @throws IllegalArgumentException if there are duplicate numbers.
     */
    override fun validate(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toInt() }
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
        return numbers
    }
}
