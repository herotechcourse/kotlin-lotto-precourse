package lotto.presentation

import lotto.presentation.ErrorMessages.INVALID_NUMBER

object IntParser {
    fun parseSingle(rawInput: String): Int =
        rawInput.toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER)
}
