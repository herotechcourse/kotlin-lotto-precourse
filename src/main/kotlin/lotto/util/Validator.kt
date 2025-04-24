package lotto.util

object Validator {

    fun validateNumberRange(numbers: List<Int>) {
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }
}
