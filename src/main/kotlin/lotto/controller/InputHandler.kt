package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.support.Validator
import lotto.support.RetryHelper

object InputHandler {
    fun requestPurchaseAmount(): Int = RetryHelper.retry {
        OutputView.printPurchaseAmountPrompt()
        val amount = InputView.getLineAsInt()
        Validator.validatePurchaseAmount(amount)
        amount
    }

    fun requestWinningTicket(): List<Int> = RetryHelper.retry {
        OutputView.printWinningTicketPrompt()
        val ticket = InputView.getLineAsList()
        Validator.validateWinningTicket(ticket)
        ticket
    }

    fun requestBonusNumber(ticket: List<Int>): Int = RetryHelper.retry {
        OutputView.printBonusNumberPrompt()
        val bonus = InputView.getLineAsInt()
        Validator.validateBonusNumber(bonus, ticket)
        bonus
    }
}
