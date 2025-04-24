package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.service.LottoManager
import lotto.models.WinningLotto
import lotto.models.Lotto

fun main() {
    val outputView = OutputView()

    val purchasedAmount = InputView.getPurchaseAmount();

    val ticketAmount = purchasedAmount / 1000

    val tickets = LottoManager.generateMultipleTickets(ticketAmount)

    outputView.displayPurchasedTicketsInfo(tickets)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()

    val winningTicket = WinningLotto(Lotto(winningNumbers), bonusNumber)

    val rankCount = LottoManager.compareTickets(tickets, winningTicket)
    outputView.displayResult(rankCount)
}
