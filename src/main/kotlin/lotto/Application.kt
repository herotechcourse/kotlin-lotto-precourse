package lotto

import lotto.domain.LottoMachine
import lotto.util.LottoValidator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    LottoValidator.validateAmount(amount)

    val tickets = LottoMachine.createTickets(amount)
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    LottoValidator.validateWinningNumbers(winningNumbers)

    val bonusNumber = InputView.readBonusNumber()
    LottoValidator.validateBonusNumber(bonusNumber, winningNumbers)

    val result = LottoMachine.calculateResult(tickets, winningNumbers, bonusNumber)
    OutputView.printResult(result, amount)
}
