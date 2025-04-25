package view

import camp.nextstep.edu.missionutils.Console
import util.Parser

object Input {
    fun readPurchaseAmountSafely(): Int = readSafely(Parser::toPurchaseAmount)

    fun readWinningNumbersSafely(): List<Int> = readSafely(Parser::toWinningNumbers)

    fun readBonusNumberSafely(): Int = readSafely(Parser::toBonusNumber)

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
