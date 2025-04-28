package lotto.engine

import lotto.domain.ITicketMachine
import lotto.domain.ResultCalculator
import lotto.domain.TicketMachine
import lotto.util.DefaultNumberGenerator
import lotto.util.NumberGenerator
import lotto.validator.InputValidator
import lotto.validator.Validator
import lotto.view.IInputView
import lotto.view.IOutputView
import lotto.view.InputView
import lotto.view.OutputView

class LottoEngine(
    val validator: Validator = InputValidator(),
    val inputView: IInputView = InputView(validator),
    val generator: NumberGenerator = DefaultNumberGenerator(),
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
