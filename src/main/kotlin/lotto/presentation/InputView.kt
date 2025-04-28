package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.BonusNumber
import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers
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

    fun readPurchaseAmount(): PurchaseAmount =
        repeatRead("Please enter the purchase amount.") { PurchaseAmount(parseSingle(Console.readLine())) }

    fun readWinningNumbers(): WinningNumbers =
        repeatRead("Please enter last week's winning numbers.") { WinningNumbers(parseMultiple(Console.readLine())) }

    fun readBonusNumber(): BonusNumber =
        repeatRead("Please enter the bonus number.") { BonusNumber(parseSingle(Console.readLine())) }
}
