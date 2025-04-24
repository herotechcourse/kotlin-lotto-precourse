package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator

object InputView {

    // Request and validate purchase amount
    fun requestPurchaseAmount(): Int {
        println("Please enter the purchase amount for lottery tickets:")
        return retryUntilValid(InputValidator::parseAmount)
    }

    // Request and validate winning numbers
    fun requestWinningNumbers(): List<Int> {
        println("Please enter the winning numbers (comma-separated):")
        return retryUntilValid(InputValidator::parseWinningNumbers)
    }

    // Request and validate bonus number
    fun requestBonusNumber(): Int {
        println("Please enter the bonus number:")
        return retryUntilValid(InputValidator::parseBonusNumber)
    }

    // Common retry logic
    private inline fun <T> retryUntilValid(parse: (String) -> T): T {
        while (true) {
            val input = Console.readLine()?.trim() ?: continue
            runCatching { return parse(input) }
                .onFailure { println(it.message) }
        }
    }
}
