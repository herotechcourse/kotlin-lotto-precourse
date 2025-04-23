package lotto.ui

import camp.nextstep.edu.missionutils.Console
import java.util.*

private const val PURCHASE_AMOUNT_UNIT = 1000
private const val MIN_PURCHASE_AMOUNT = PURCHASE_AMOUNT_UNIT
private const val ERROR_PREFIX = "[ERROR]"

class InputView {

    private fun <T> readValidatedInput(prompt: String, parseAndValidate: () -> T): T {
        while (true) {
            println(prompt)
            try {
                return parseAndValidate()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getPurchaseAmount(): Int {
        return readValidatedInput("Please enter the purchase amount.") {
            val amount = Console.readLine().toIntOrNull()
                ?: throw IllegalArgumentException("$ERROR_PREFIX Input must be a valid number")
            validatePurchaseAmount(amount)
            amount
        }
    }

    fun getWinningNumbers(): SortedSet<Int> {
        return readValidatedInput("Please enter the last week's winning numbers.") {
            val winningNumbersStr = Console.readLine()
            val winningNumbers = parseWinningNumbers(winningNumbersStr)
            validateWinningNumbers(winningNumbers)
            winningNumbers
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        if (amount < MIN_PURCHASE_AMOUNT) {
            throw IllegalArgumentException("$ERROR_PREFIX Purchase amount must be at least $MIN_PURCHASE_AMOUNT KRW")
        }
        if (amount % PURCHASE_AMOUNT_UNIT != 0) {
            throw IllegalArgumentException("$ERROR_PREFIX Purchase amount must be in units of $PURCHASE_AMOUNT_UNIT KRW")
        }
    }

    private fun parseWinningNumbers(winningNumbersStr: String): SortedSet<Int> {
        val numbers = winningNumbersStr
            .split(",")
            .map {
                it.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("$ERROR_PREFIX All Lotto numbers must be numbers")
            }
        return numbers.toSortedSet()
    }

    private fun validateWinningNumbers(numbers: SortedSet<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("$ERROR_PREFIX Lotto numbers must be 6 unique numbers")
        }
        numbers.forEach { number ->
            if (number !in 1..45) {
                throw IllegalArgumentException("$ERROR_PREFIX Lotto numbers must be between 1 and 45")
            }
        }
    }
}