package lotto.presentation

import lotto.presentation.ErrorMessages.INVALID_NUMBER

object IntParser {
    fun parseSingle(rawInput: String): Int =
        rawInput.trim().toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER)

    fun parseMultiple(rawInput: String): List<Int> =
        rawInput.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER) }
}
