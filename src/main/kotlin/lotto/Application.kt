package lotto

import lotto.service.ProfitCalculator
import lotto.service.ResultAnalyzer
import lotto.service.TicketGenerator
import lotto.ui.InputView
import lotto.ui.InputView.readPurchaseAmount
import lotto.ui.OutputView
import lotto.ui.OutputView.printTickets


fun main() {
    val gen = TicketGenerator()
    val analyzer = ResultAnalyzer()
    val calc = ProfitCalculator()

    val purchaseAmount = readPurchaseAmount()
    val tickets = gen.generate(purchaseAmount)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    val stats = analyzer.analyze(tickets, winningNumbers, bonusNumber)
    val profitRate = calc.calculate(stats, purchaseAmount)

    printTickets(tickets)
    OutputView.printStatistics(stats)
    OutputView.printProfitRate(profitRate)
}
