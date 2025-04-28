package lotto.view

import lotto.utils.readLineFromConsole
import lotto.utils.validateBonusNotDuplicate
import lotto.utils.validateDivisibleByThousand
import lotto.utils.validateNumberSeparatedWithCommas
import lotto.utils.validateNotBlank
import lotto.utils.validateNumberCount
import lotto.utils.validateNumberRange
import lotto.utils.validateUniqueNumbers
import lotto.utils.validateIsNumber

import lotto.LOTTO_NUMBER_COUNT

object InputView {

    fun readPurchaseAmount(): Int = retryUntilValid {
        val input = readLineFromConsole("Please enter the purchase amount.")
        validateNotBlank(input)
        validateIsNumber(input)
        val amount = input.toInt()
        validateDivisibleByThousand(amount)
        amount
    }

    fun readWinningNumbers(): List<Int> = retryUntilValid {
        val input = readLineFromConsole("Please enter last week's winning numbers.")
        validateNotBlank(input)
        validateNumberSeparatedWithCommas(input)
        val numbers = parseCommaSeparatedNumbers(input)
        validateNumberCount(numbers, LOTTO_NUMBER_COUNT)
        validateNumberRange(numbers)
        validateUniqueNumbers(numbers)
        numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int = retryUntilValid {
        val input = readLineFromConsole("Please enter the bonus number.")
        validateNotBlank(input)
        validateIsNumber(input)
        val bonusNumber = input.toInt()
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
