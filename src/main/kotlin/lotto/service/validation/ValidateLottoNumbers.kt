package lotto.service.validation

class ValidateLottoNumbers {
    fun validate(numbers: List<Int>) {
        require(numbers.isNotEmpty()) { "[ERROR] Lotto must not be empty." }
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }
}