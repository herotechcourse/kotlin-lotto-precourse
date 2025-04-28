package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.presentation.IntParser.parseMultiple
import lotto.presentation.IntParser.parseSingle
import java.lang.IllegalArgumentException

object InputView {
    private fun <T> repeatRead(prompt: String, parse: () -> T): T {
        while (true) {
            try {
                println(prompt)
                return parse()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readPurchaseAmount(): Int =
        repeatRead("Please enter the purchase amount.") { parseSingle(Console.readLine()) }

    fun readWinningNumbers(): List<Int> =
        repeatRead("Please enter last week's winning numbers.") { parseMultiple(Console.readLine()) }

    fun readBonusNumber(): Int =
        repeatRead("Please enter the bonus number.") { parseSingle(Console.readLine()) }
}
