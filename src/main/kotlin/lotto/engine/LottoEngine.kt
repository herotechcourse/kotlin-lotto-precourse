package lotto.engine

import lotto.domain.ITicketMachine
import lotto.domain.ResultCalculator
import lotto.domain.TicketMachine
import lotto.util.DefaultINumberGenerator
import lotto.util.INumberGenerator
import lotto.util.retry
import lotto.validator.IInputValidator
import lotto.validator.InputValidator
import lotto.view.IOutputView
import lotto.view.InputView
import lotto.view.OutputView

class LottoEngine(
    val inputValidator: IInputValidator = InputValidator(),
    val inputView: InputView = InputView(inputValidator),
    val generator: INumberGenerator = DefaultINumberGenerator(),
    val ticketMachine: ITicketMachine = TicketMachine(generator),
    val outputView: IOutputView = OutputView()
) {

    fun run() {
        // 1) Purchase & tickets
        val amount = retry { inputView.readPurchaseAmount() }
        val tickets = ticketMachine.issue(amount)

        outputView.printTickets(tickets.map { it.getNumbers() })

        // 2) Winning numbers & bonus
        val winning = retry { inputView.readWinningNumbers().toSet() }
        val bonus = retry { inputView.readBonusNumber() }

        // 3) Calculate results & rate
        val calculator = ResultCalculator(winning, bonus)

        val results = calculator.calculate(tickets)
        val rate = calculator.profitRate(results, amount)

        // 4) Display statistics
        outputView.printStatistics(results, rate)
    }
}
