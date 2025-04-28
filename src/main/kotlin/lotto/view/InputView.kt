package lotto.view

import lotto.utils.readLineFromConsole
import lotto.utils.validateBonusNotDuplicate
import lotto.utils.validateDivisibleByThousand
import lotto.utils.validateNumberSeparatedWithCommas
import lotto.utils.validateNotBlank
import lotto.utils.validateNumberCount
import lotto.utils.validateNumberRange
import lotto.utils.validateUniqueNumbers

object InputView {

    fun readPurchaseAmount(): Int = retryUntilValid {
        val input = readLineFromConsole("Please enter the purchase amount.")
        validateNotBlank(input)
        val amount = input.toInt()
        validateDivisibleByThousand(amount)
        amount
    }

    fun readWinningNumbers(): List<Int> = retryUntilValid {
        val input = readLineFromConsole("Please enter last week's winning numbers.")
        validateNotBlank(input)
        validateNumberSeparatedWithCommas(input)
        val numbers = parseCommaSeparatedNumbers(input)
        validateNumberCount(numbers, 6)
        validateNumberRange(numbers)
        validateUniqueNumbers(numbers)
        numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int = retryUntilValid {
        val input = readLineFromConsole("Please enter the bonus number.")
        validateNotBlank(input)
        val bonusNumbers = parseCommaSeparatedNumbers(input)
        validateNumberCount(bonusNumbers, 1)
        val bonusNumber = bonusNumbers.first()
        validateBonusNotDuplicate(winningNumbers, bonusNumber)
        bonusNumber
    }

    private fun parseCommaSeparatedNumbers(input: String): List<Int> {
        return input.split(",")
            .map { it.trim().toInt() }
    }

    private fun <T> retryUntilValid(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}

