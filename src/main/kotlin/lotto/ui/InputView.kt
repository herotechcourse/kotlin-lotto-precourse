package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
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

    fun getWinningNumbers(): Lotto {
        return readValidatedInput("Please enter the last week's winning numbers.") {
            val winningNumbers = parseWinningNumbers(Console.readLine())
            Lotto(winningNumbers)
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

    private fun parseWinningNumbers(input: String): List<Int> {
        val numbers = input
            .split(",")
            .map {
                it.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("$ERROR_PREFIX All Lotto numbers must be numbers")
            }
        return numbers
    }
}