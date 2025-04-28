package lotto.validators

class NumbersRangeValidator(minNumber: Int, maxNumber: Int) :
        RangeValidator<List<Int>>(minNumber, maxNumber) {

    /**
     * Validates the input comma separated values are within specific range.
     *
     * @param input The input value to validate.
     * @return The validated value as a list of integers.
     * @throws IllegalArgumentException if any number is not in the specified range.
     */
    override fun validate(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toInt() }
        numbers.forEach { validateRange(it) }
        return numbers
    }
}
