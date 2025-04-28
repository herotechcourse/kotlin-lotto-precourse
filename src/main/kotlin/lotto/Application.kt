package lotto

import lotto.services.LottoMachine
import lotto.services.LottoResult
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    try {
        val purchaseAmount = InputView.readPurchaseAmount()
        val tickets = LottoMachine.issueLottos(purchaseAmount)

        OutputView.printTickets(tickets)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()


        val result = LottoResult(tickets, winningNumbers, bonusNumber)

        OutputView.printStatistics(result)

    } catch (e: IllegalArgumentException) {

    }

}

