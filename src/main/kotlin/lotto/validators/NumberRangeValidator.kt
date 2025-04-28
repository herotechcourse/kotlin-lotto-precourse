package lotto.validators

class NumberRangeValidator(minNumber: Int, maxNumber: Int) :
        RangeValidator<Int>(minNumber, maxNumber) {

    /**
     * Validates the input value with the specified range.
     *
     * @param input The input value to validate.
     * @return The validated value.
     * @throws IllegalArgumentException if the value is not in the specified range.
     */
    override fun validate(input: String): Int {
        val number = input.toInt()
        validateRange(number)
        return number
    }
}
