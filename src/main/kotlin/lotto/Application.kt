package lotto

import lotto.domain.WinningNumbers
import lotto.service.LottoGameService
import lotto.service.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // TODO: Implement the program
    try {
        val amount = InputView.readPurchaeAmount()
        val ticketCount = amount / 1000

        val machine = LottoMachine()
        val tickets = machine.generateTickets(ticketCount)

        OutputView.printTickets(tickets)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()

        val result = WinningNumbers(winningNumbers, bonusNumber)

        val gameService = LottoGameService()
        val resultMap = gameService.evaluateTickets(tickets, result)

        println(resultMap)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
