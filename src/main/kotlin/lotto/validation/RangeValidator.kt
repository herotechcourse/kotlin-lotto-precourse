package lotto.validation

object RangeValidator {

    fun validateInRange(number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException("[ERROR] Number must be between 1 and 45.")
        }
    }
}
