package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.service.LottoManager
import lotto.models.WinningLotto
import lotto.Lotto

fun main() {
    try {
        val outputView = OutputView()

        val purchasedAmount = InputView.getPurchaseAmount()
        val ticketAmount = LottoManager.calculateTicketAmount(purchasedAmount)

        val tickets = LottoManager.generateMultipleTickets(ticketAmount)
        outputView.displayPurchasedTicketsInfo(tickets)

        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber()

        val winningTicket = LottoManager.createWinningLotto(winningNumbers, bonusNumber)

        val rankCount = LottoManager.compareTickets(tickets, winningTicket)
        val returnRate = LottoManager.calculateReturnRate(rankCount, purchasedAmount)
        outputView.displayResult(rankCount, returnRate)
    }
    catch (e: IllegalArgumentException) {
        println(e.message)  
    }
    
}
