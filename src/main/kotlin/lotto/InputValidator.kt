package lotto

import lotto.Constants.LOTTO_MAX_NUMBER
import lotto.Constants.LOTTO_MIN_NUMBER
import lotto.Constants.LOTTO_NUMBER_COUNT


object InputValidator {

    fun parseAndValidateLottoNumbers(input: String): List<Int> {
        val numbers = input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Lotto numbers must be numbers.")
        }

        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "[ERROR] Lotto must contain exactly $LOTTO_NUMBER_COUNT numbers."
        }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            "[ERROR] Lotto numbers must be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER."
        }

        return numbers.sorted()
    }

    fun parseAndValidateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val number =
            input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")

        require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            "[ERROR] Bonus number must be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER."
        }
        require(number !in winningNumbers) { "[ERROR] Bonus number must not be in the winning numbers." }

        return number
    }
}
