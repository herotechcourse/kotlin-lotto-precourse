package lotto.controller

import lotto.Lotto
import lotto.LottoStore
import lotto.Lottos
import lotto.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class Controller(private val store: LottoStore) {

    fun run() {
        val lottos: Lottos = retry { store.sell(InputView.readPurchaseAmount()) }
        OutputView.printLottos(lottos)

        val winningNumbers: Lotto = retry { Lotto(InputView.readWinningNumbers()) }
        val winningLotto: WinningLotto = retry { WinningLotto(winningNumbers, InputView.readBonusNumber()) }

        OutputView.printFinalReport(rankCounts = lottos.matchAll(winningLotto), profitRate = lottos.profitRate(winningLotto))
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
