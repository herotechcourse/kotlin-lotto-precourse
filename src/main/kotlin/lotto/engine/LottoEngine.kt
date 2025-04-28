package lotto.engine

import lotto.domain.ITicketMachine
import lotto.domain.ResultCalculator
import lotto.domain.TicketMachine
import lotto.util.DefaultINumberGenerator
import lotto.util.INumberGenerator
import lotto.validator.InputValidator
import lotto.validator.IInputValidator
import lotto.view.IInputView
import lotto.view.IOutputView
import lotto.view.InputView
import lotto.view.OutputView

class LottoEngine(
    val inputValidator: IInputValidator = InputValidator(),
    val inputView: IInputView = InputView(inputValidator),
    val generator: INumberGenerator = DefaultINumberGenerator(),
    val ticketMachine: ITicketMachine = TicketMachine(generator),
    val outputView: IOutputView = OutputView
) {

    fun run() {
        // 1) Purchase & tickets
        val amount = inputView.readPurchaseAmount()
        val tickets = ticketMachine.issue(amount)

        outputView.printTickets(tickets.map { it.getNumbers() })

        // 2) Winning numbers & bonus
        val winning = inputView.readWinningNumbers().toSet()
        val bonus = inputView.readBonusNumber()

        // 3) Calculate results & rate
        val calculator = ResultCalculator(winning, bonus)

        val results = calculator.calculate(tickets)
        val rate = calculator.profitRate(results, amount)

        // 4) Display statistics
        outputView.printStatistics(results, rate)
    }
}
