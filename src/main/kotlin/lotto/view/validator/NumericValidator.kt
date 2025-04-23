package lotto.view.validator

object NumericValidator {

    fun validate(value: String) {
        if (value.toIntOrNull() == null)
            throw IllegalArgumentException("Amount must be numeric value")
    }

}