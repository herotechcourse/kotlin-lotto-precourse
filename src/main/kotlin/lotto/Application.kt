package lotto

import WinningNumbers
import lotto.domain.*
import lotto.io.*

fun main() {
    val io = IOConsole()
    val inputView = InputView(io)
    val outputView = OutputView(io)

    val purchaseAmount = inputView.readPurchaseAmount()
    val ticketCount = purchaseAmount / 1000
    val tickets = (1..ticketCount).map { LottoTicketGenerator.generate() }
    outputView.printPurchasedTickets(tickets)

    val winningNumbers = inputView.readWinningNumbers()
    val bonusNumber = inputView.readBonusNumber()
    val winning = WinningNumbers(winningNumbers, bonusNumber)

    val resultCalculator = ResultCalculator()
    val result = resultCalculator.calculate(tickets, winning)
    val profitRate = resultCalculator.calculateProfitRate(result, purchaseAmount)

    outputView.printResult(result, profitRate)
}
