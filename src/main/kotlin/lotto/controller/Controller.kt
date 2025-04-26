package lotto.controller

import lotto.*
import lotto.view.CountRankResponse
import lotto.view.InputView
import lotto.view.OutputView

class Controller(
    private val store: LottoStore = LottoStore(),
    private val inputView: InputView = InputView,
    private val outputView: OutputView = OutputView()
) {

    fun run() {
        val lottoTickets: LottoTickets = purchase()
        outputView.printLottoTickets(lottoTickets.getTickets().map { it.getNumbers() })

        val winningStatistics: WinningStatistics = evaluate(lottoTickets)
        outputView.printFinalReport(
            rankCounts = winningStatistics.toCountRankResponses(),
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

    private fun WinningStatistics.toCountRankResponses(): List<CountRankResponse> = Rank
        .entries
        .filter { it != Rank.NONE }
        .map { CountRankResponse(it, getCount(it)) }

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
