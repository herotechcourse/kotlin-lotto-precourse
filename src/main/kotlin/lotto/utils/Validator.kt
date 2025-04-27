package lotto.utils

object Validator {
    fun validateAmount(amount: Int) {
        require(amount >= 1000 && amount % 1000 == 0) { "[ERROR] Amount must be multiples of 1000." }
    }

    fun validateNumberRange(numbers: List<Int>) {
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }
}