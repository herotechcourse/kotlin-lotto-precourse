package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoResult
import lotto.domain.WinningLotto
import lotto.util.calculateAndFormatReturnRate
import lotto.view.OutputView
import lotto.Lotto

object LottoController {
    fun start() {
        val tickets = issueTickets()
        val winningLotto = handleWinningNumbers()
        handlePrize(tickets, winningLotto)
    }

    private fun issueTickets(): List<Lotto> {
        val purchaseAmount = InputHandler.requestPurchaseAmount()
        val tickets = LottoMachine.generateTickets(purchaseAmount)
        OutputView.printTickets(tickets)
        return tickets
    }

    private fun handleWinningNumbers(): WinningLotto {
        val winningNumbers = InputHandler.requestWinningTicket()
        val bonusNumber = InputHandler.requestBonusNumber(winningNumbers)
        return WinningLotto(winningNumbers, bonusNumber)
    }

    private fun handlePrize(tickets: List<Lotto>, winningLotto: WinningLotto) {
        val prize = LottoResult.checkResult(tickets, winningLotto)
        val returnRate = calculateAndFormatReturnRate(prize, tickets)
        OutputView.printPrizeResult(prize)
        OutputView.printProfit(returnRate)
    }
}
