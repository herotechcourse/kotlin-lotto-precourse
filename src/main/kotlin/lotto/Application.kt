package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView


fun main() {
    val amount = InputView.readPurchaseAmount()
    val lottoMachine = LottoMachine()
    val tickets = lottoMachine.issueTickets(amount)

    OutputView.printTickets(tickets)
}