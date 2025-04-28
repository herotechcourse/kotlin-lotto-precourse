package lotto.validator

object LottoValidator {
    fun validate(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Lotto must contain exactly 6 numbers.")
        }

        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be unique.")
        }
    }
}