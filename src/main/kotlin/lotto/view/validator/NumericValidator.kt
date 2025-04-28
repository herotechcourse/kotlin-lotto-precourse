package lotto.view.validator

object NumericValidator {

    fun validate(input: String) {
        val value = input.toIntOrNull()

        if (value == null)
            throw IllegalArgumentException("Amount must be numeric value")

        if (value < 0)
            throw IllegalArgumentException("Amount must be positive")
    }

}