package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator

object InputView {

    fun requestPurchaseAmount(): Int {
        println("Please enter the purchase amount for lottery tickets:")
        return retryUntilValid(InputValidator::parseAmount)
    }

    fun requestWinningNumbers(): List<Int> {
        println("Please enter the winning numbers (comma-separated):")
        return retryUntilValid(InputValidator::parseWinningNumbers)
    }

    fun requestBonusNumber(): Int {
        println("Please enter the bonus number:")
        return retryUntilValid(InputValidator::parseBonusNumber)
    }

    private inline fun <T> retryUntilValid(parse: (String) -> T): T {
        while (true) {
            val input = Console.readLine()?.trim() ?: continue
            runCatching { return parse(input) }
                .onFailure { println(it.message) }
        }
    }
}
