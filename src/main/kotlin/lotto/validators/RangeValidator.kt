package lotto.validators

abstract class RangeValidator<T>(
    private val minNumber: Int,
    private val maxNumber: Int
) : InputValidator<T> {
    /**
     * Validates that minNumber and maxNumber are greater than zero and that minNumber is less than maxNumber.
     */
    init {
        require(minNumber > 0) { "Minimum value must be greater than zero." }
        require(maxNumber > 0) { "Maximum value must be greater than zero." }
        require(minNumber < maxNumber) { "Minimum value must be less than maximum value." }
    }

    /**
     * Validates the input value with the specified range.
     *
     * @param input The input value to validate.
     * @return The validated value.
     * @throws IllegalArgumentException if the value is not in the specified range.
     */
    protected fun validateRange(value: Int) {
        if (value < minNumber || value > maxNumber) {
            throw IllegalArgumentException("[ERROR] Value must be in the range from $minNumber to $maxNumber.")
        }
    }
}
