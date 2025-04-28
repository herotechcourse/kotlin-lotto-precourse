package lotto.common

object Parser {
    fun toInt(input: String): Int =
        input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.INVALID_INPUT_NUMBER)

    fun toIntList(input: String): List<Int> = input.split(",")
        .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.INVALID_INPUT_NUMBER) }
}