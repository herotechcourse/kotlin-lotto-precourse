package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.support.Validator

object InputHandler {
    fun requestPurchaseAmount(): Int = retryInput {
        OutputView.printPurchaseAmountPrompt()
        val amount = InputView.getLineAsInt()
        Validator.validatePurchaseAmount(amount)
        amount
    }

    fun requestWinningTicket(): List<Int> = retryInput {
        OutputView.printWinningTicketPrompt()
        val ticket = InputView.getLineAsList()
        Validator.validateWinningTicket(ticket)
        ticket
    }

    fun requestBonusNumber(ticket: List<Int>): Int = retryInput {
        OutputView.printBonusNumberPrompt()
        val bonus = InputView.getLineAsInt()
        Validator.validateBonusNumber(bonus, ticket)
        bonus
    }

    private fun <T> retryInput(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message)
            }
        }
    }
}
