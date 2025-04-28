package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.InputMessage
import lotto.domain.validator.InputValidator

object InputView {
    fun getPurchaseAmount(): Int {
        return try {
            println(InputMessage.PURCHASE.message)
            val input: String = Console.readLine()

            return InputValidator.validatePurchaseAmount(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getPurchaseAmount()
        }
    }

    fun getWinningNumbers(): Set<Int> {
        return try {
            println(InputMessage.WINNING_NUMBER.message)
            val input: String = Console.readLine()

            return InputValidator.validateWinningNumbers(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getWinningNumbers()
        }
    }

    fun getBonusNumber(winningNumbers: Set<Int>): Int {
        return try {
            println(InputMessage.BONUS_NUMBER.message)
            val input: String = Console.readLine()

            return InputValidator.validateBonusNumber(input, winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getBonusNumber(winningNumbers)
        }
    }
}