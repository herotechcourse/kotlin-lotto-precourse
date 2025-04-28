package lotto.validators

class CombinedValidator<T>(private val validators: List<InputValidator<T>>) : InputValidator<T> {
    init {
        require(validators.isNotEmpty()) { "At least one validator is required." }
    }

    /**
     * Validates the input string using all provided validators in sequence. If any validator throws
     * an exception, the validation fails.
     *
     * @param input The input string to validate.
     * @return The result of the last validator.
     * @throws IllegalArgumentException if any validator fails.
     */
    @Throws(IllegalArgumentException::class)
    override fun validate(input: String): T {
        var result = validators[0].validate(input)
        for (validator in validators.drop(1)) {
            result = validator.validate(input) // will throw if invalid
        }
        return result
    }
}
