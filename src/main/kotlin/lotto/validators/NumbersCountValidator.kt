package lotto.validators

/** 
 * Validator class to ensure the input string contains the correct number of winning numbers.
*/
class NumbersCountValidator(
    private val numbersCount: Int
) : InputValidator<List<Int>> {
    /**
     * Validates the input string to ensure it contains the correct number of winning numbers.
     *
     * @param numbersCount The expected number of winning numbers.
     */
    init {
        require(numbersCount > 0) { "Numbers count must be greater than zero." }
    }

    /**
     * Validates the input string to ensure it contains the correct number of winning numbers.
     *
     * @param input The input string containing the winning numbers.
     * @return A list of integers representing the winning numbers.
     * @throws IllegalArgumentException if the input does not contain the correct number of winning numbers.
     */
    override fun validate(input: String): List<Int> {
        val numbers =
            input.split(",").map {
                it.trim().toInt()
            }
        if (numbers.size != numbersCount) {
            throw IllegalArgumentException("[ERROR] The amount of winning numbers must equal 6.")
        }
        return numbers
    }
}
