package lotto

import lotto.domain.WinningLotto
import lotto.service.LottoMachine
import lotto.service.LottoStatistics
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount = retry {  InputView.readPurchaseAmount()}
    val lottoMachine = LottoMachine()
    val tickets = lottoMachine.generateTickets(amount)
    OutputView.printTickets(tickets)

    val winningNumbers = retry {InputView.readWinningNumbers()}
    val bonusNumber = retry {InputView.readBonusNumber()}
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val statistics = LottoStatistics.calculate(tickets, winningLotto)
    OutputView.printStatistics(statistics, amount)
}

fun <T> retry(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
