package lotto

import lotto.core.LottoGame
import lotto.utils.InputView
import lotto.utils.LottoMachine
import lotto.utils.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val ticketCount = LottoMachine.calculateTicketCount(purchaseAmount)
    val tickets = LottoMachine.generateTickets(ticketCount)

    OutputView.printTickets(tickets)

    val winningTicket = InputView.readWinningTicket()
    val bonusNumber = InputView.readBonusNumber(winningTicket)

    val lottoGame = LottoGame(
        winningTicket = winningTicket,
        bonusNumber = bonusNumber
    )

    val result = lottoGame.evaluateTickets(
        tickets = tickets
    )

    val returnRate = lottoGame.calculateReturnRate(result, purchaseAmount)

    OutputView.printResult(result, returnRate)

}
