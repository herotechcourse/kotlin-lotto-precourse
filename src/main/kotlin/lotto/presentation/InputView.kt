package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.presentation.IntParser.parseMultiple
import lotto.presentation.IntParser.parseSingle

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")

        return parseSingle(Console.readLine())
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")

        return parseMultiple(Console.readLine())
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")

        return parseSingle(Console.readLine())
    }
}
