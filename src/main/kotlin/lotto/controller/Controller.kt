package lotto.controller

import lotto.*
import lotto.view.InputView
import lotto.view.OutputView

class Controller(
    private val store: LottoStore = LottoStore(),
    private val inputView: InputView = InputView,
    private val outputView: OutputView = OutputView()
) {

    fun run() {
        val lottoTickets: LottoTickets = purchase()
        outputView.printLottoTickets(ResponseMapper.toResponses(lottoTickets))

        val winningStatistics: WinningStatistics = evaluate(lottoTickets)
        outputView.printFinalReport(
            rankCounts = ResponseMapper.toResponses(winningStatistics),
            profitRate = winningStatistics.profitRate()
        )
    }

    private fun purchase(): LottoTickets {
        val amount: Money = retry { Money(inputView.readPurchaseAmount()) }

        return store.sell(amount)
    }

    private fun evaluate(lottoTickets: LottoTickets): WinningStatistics {
        val winningNumbers: Lotto = retry { Lotto(inputView.readWinningNumbers()) }
        val winningLotto: WinningLotto = retry { WinningLotto(winningNumbers, inputView.readBonusNumber()) }

        return lottoTickets.evaluate(winningLotto)
    }

    private fun <T> retry(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (ex: IllegalArgumentException) {
                outputView.printError(ex.message)
            }
        }
    }

}
