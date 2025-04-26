package view

import camp.nextstep.edu.missionutils.Console
import util.Parser

object Input {
    private const val EXIT_COMMAND = "EXIT"

    fun readPurchaseAmountSafely(): Int? = readSafely(Parser::toPurchaseAmount)

    fun readWinningNumbersSafely(): List<Int>? = readSafely(Parser::toWinningNumbers)

    fun readBonusNumberSafely(winningNumbers: List<Int>): Int? = readSafely { input -> Parser.toBonusNumber(input, winningNumbers) }

    private fun <T> readSafely(block: (String) -> T): T? {
        while (true) {
            try {
                val input = Console.readLine()
                if (input.uppercase() == EXIT_COMMAND) return null
                return block(input)
            } catch (exception: IllegalArgumentException) {
                println(exception.message)
            }
        }
    }
}
