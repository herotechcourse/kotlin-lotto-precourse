package lotto.validator

object NumericValidator {

    fun validate(input: String): Int {
        val value = input.toIntOrNull()

        if (value == null)
            throw IllegalArgumentException("[ERROR] Amount must be numeric value")

        if (value < 0)
            throw IllegalArgumentException("[ERROR] Amount must be positive")

        return value
    }

}