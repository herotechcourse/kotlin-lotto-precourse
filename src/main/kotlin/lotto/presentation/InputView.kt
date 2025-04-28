package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.presentation.IntParser.parseMultiple
import lotto.presentation.IntParser.parseSingle

object InputView {
    fun readPurchaseAmount(): Int {
        println("Purchase amount for lottery tickets:")

        return parseSingle(Console.readLine())
    }

    fun readWinningNumbers(): List<Int> {
        println("Winning numbers (comma-separated):")

        return parseMultiple(Console.readLine())
    }
}
