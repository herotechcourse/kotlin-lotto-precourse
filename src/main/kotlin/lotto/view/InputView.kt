package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.common.Parser

object InputView {
    fun readPurchaseAmount(): Int = safeRead("Please enter the purchase amount.") { Parser.toInt(Console.readLine()) }

    fun readWinningNumbers(): List<Int> =
        safeRead("Please enter last week's winning numbers.") { Parser.toIntList(Console.readLine()) }

    fun readBonusNumber(): Int = safeRead("Please enter the bonus number.") { Parser.toInt(Console.readLine()) }

    private fun <T> safeRead(message: String, parser: () -> T): T {
        try {
            println(message)
            return parser()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return safeRead(message, parser)
        } catch (e: IllegalStateException) {
            println(e.message)
            return safeRead(message, parser)
        }
    }
}