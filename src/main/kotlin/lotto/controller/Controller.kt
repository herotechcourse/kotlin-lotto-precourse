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
        val amount: Money = retry { Money(InputView.readPurchaseAmount()) }
        val lottos: Lottos = store.sell(amount)
        outputView.printLottoTickets(lottos)

        val winningNumbers: Lotto = retry { Lotto(inputView.readWinningNumbers()) }
        val winningLotto: WinningLotto = retry { WinningLotto(winningNumbers, inputView.readBonusNumber()) }

        outputView.printFinalReport(
            rankCounts = lottos.matchAll(winningLotto),
            profitRate = lottos.profitRate(winningLotto)
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
