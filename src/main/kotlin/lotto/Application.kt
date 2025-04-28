package lotto

import lotto.services.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val tickets = LottoMachine.issueLottos(purchaseAmount)

    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()

}

