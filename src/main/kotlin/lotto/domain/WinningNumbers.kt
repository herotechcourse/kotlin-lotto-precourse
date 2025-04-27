package lotto.domain

import lotto.Lotto
import java.lang.IllegalArgumentException

class WinningNumbers(inputWinningNumbers: String) {

    val numbers: List<Int>

    init {
        val parsedNumbers = parseInputString(inputWinningNumbers)
        try {
            Lotto(parsedNumbers)
            numbers = parsedNumbers
        } catch (e: IllegalArgumentException) {
            throw e
        }
    }

    private fun parseInputString(input: String): List<Int> {
        require(input.isNotBlank()) { Lotto.ERROR_INPUT_EMPTY }
        require(!input.endsWith(DELIMITER)) { ERROR_HAS_DELIMITER }

        val numberStrings = input.split(DELIMITER)

        return numberStrings.map { part ->
            val trimmedPart = part.trim()
            require(trimmedPart.isNotEmpty()) { Lotto.ERROR_INPUT_EMPTY }
            trimmedPart.toIntOrNull()
                ?: throw IllegalArgumentException(Lotto.ERROR_NOT_VALID_NUMBER)
        }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        private const val DELIMITER = ","
        private const val ERROR_HAS_DELIMITER = "[ERROR] Winning numbers input cannot end with a delimiter '$DELIMITER'."
    }

}