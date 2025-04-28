package lotto

import lotto.domain.LottoMachine
import lotto.utils.getValidatedInput
import lotto.utils.InputValidator
import lotto.view.messages.PromptMessages
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val validator = InputValidator()
    val input = InputView()
    val view = OutputView()

    val machine = LottoMachine(readPurchaseAmount(input, validator))
    view.printTicketCount(machine.tickets.size)
    view.printLottoNumbers(machine.tickets)

    val winningNumbers = readWinningNumbers(input, validator)
    val bonusNumber = readBonusNumber(input, validator, winningNumbers)
    view.printWinningStatistics(machine.setAllRank(winningNumbers, bonusNumber))
    view.printReturnRate(machine.calculateReturnRate())
}

private fun readPurchaseAmount(inputView: InputView, validator: InputValidator): Int {
    return getValidatedInput(
        prompt = PromptMessages.PURCHASE_AMOUNT.message,
        readInput = { inputView.readOneLine(it) },
        validate = { validator.validatePurchaseInput(it) }
    )
}

private fun readWinningNumbers(inputView: InputView, validator: InputValidator): Set<Int> {
    return getValidatedInput(
        prompt = PromptMessages.WINNING_NUMBERS.message,
        readInput = { inputView.readOneLine(it) },
        validate = { validator.validateWinningNumbers(it) }
    )
}

private fun readBonusNumber(inputView: InputView, validator: InputValidator, winningNumbers: Set<Int>): Int {
    return getValidatedInput(
        prompt = PromptMessages.BONUS_NUMBER.message,
        readInput = { inputView.readOneLine(it) },
        validate = { validator.validateBonusNumber(it, winningNumbers) }
    )
}
