package lotto.controller

import lotto.*
import lotto.view.InputView
import lotto.view.OutputView

class Controller(
    private val store: LottoStore,
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val lottoTickets: LottoTickets = purchase()
        evaluate(lottoTickets)
    }

    private fun purchase(): LottoTickets {
        val amount: Money = retry { Money(inputView.readPurchaseAmount()) }
        val lottoTickets: LottoTickets = store.sell(amount)

        outputView.printLottoTickets(lottoTickets.getTickets())

        return lottoTickets
    }

    private fun evaluate(lottoTickets: LottoTickets) {
        val winningNumbers: Lotto = retry { Lotto(inputView.readWinningNumbers()) }
        val winningLotto: WinningLotto = retry { WinningLotto(winningNumbers, inputView.readBonusNumber()) }

        outputView.printFinalReport(
            rankCounts = lottoTickets.matchAll(winningLotto),
            profitRate = lottoTickets.profitRate(winningLotto)
        )
    }

    private fun <T> retry(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (ex: IllegalArgumentException) {
                println("[ERROR] ${ex.message}")
            }
        }
    }

}
