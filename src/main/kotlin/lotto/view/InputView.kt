package lotto.view

import lotto.support.Message
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getLineAsInt(): Int {
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException(Message.ERROR_INPUT_NOT_INT)
    }

    fun getLineAsList(): List<Int> {
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(Message.ERROR_INPUT_NOT_INT) }
        return numbers
    }
}