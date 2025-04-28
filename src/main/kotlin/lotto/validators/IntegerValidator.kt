package lotto.validators

class IntegerValidator : InputValidator<Int> {
    override fun validate(input: String): Int {
        if (input.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.")
        }
        if (input.any { !it.isDigit() }) {
            throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid number.")
        }

        return input.toInt()
    }
}
