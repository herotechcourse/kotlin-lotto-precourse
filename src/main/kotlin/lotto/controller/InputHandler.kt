package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.support.Validator

object InputHandler {
    fun requestPurchaseAmount(): Int {
        while (true) {
            try {
                OutputView.printPurchaseAmountPrompt()
                val amount = InputView.getLineAsInt()
                Validator.validatePurchaseAmount(amount)
                return amount
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message)
            }
        }
    }

    fun requestWinningTicket(): List<Int> {
        while (true) {
            try {
                OutputView.printWinningTicketPrompt()
                val ticket = InputView.getLineAsList()
                Validator.validateWinningTicket(ticket)
                return ticket
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message)
            }
        }
    }

    fun requestBonusNumber(ticket: List<Int>): Int {
        while (true) {
            try {
                OutputView.printBonusNumberPrompt()
                val bonus = InputView.getLineAsInt()
                Validator.validateBonusNumber(bonus, ticket)
                return bonus
            } catch (e: IllegalArgumentException) {
                OutputView.printErrorMessage(e.message)
            }
        }
    }
}