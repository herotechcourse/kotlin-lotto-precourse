package view

import camp.nextstep.edu.missionutils.Console
import util.Parser
import util.Validator

object Input {
    fun readPurchaseAmountSafely(): Int = readSafely(Parser::toPurchaseAmount)

    fun readWinningNumbersSafely(): List<Int> = readSafely(Parser::toWinningNumbers)

    fun readBonusNumberSafely(winningNumbers: List<Int>): Int = readSafely { input -> Parser.toBonusNumber(input, winningNumbers) }

    private fun <T> readSafely(block: (String) -> T): T {
        while (true) {
            try {
                val input = Console.readLine()
                return block(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
