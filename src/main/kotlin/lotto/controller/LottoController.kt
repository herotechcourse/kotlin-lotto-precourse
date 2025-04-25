package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.WinningNumber
import lotto.domain.WinningResult
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
    private val lottoMachine: LottoMachine = LottoMachine()
) {

    fun run() {
        val purchaseAmount = inputView.readPurchaseAmount()

        println()
        val lottos = lottoMachine.generateLottoTickets(purchaseAmount)
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it.getNumbers()) }

        println()
        val winningNumbers = inputView.readWinningNumber()
        val bonusNumber = inputView.readBonusNumber(winningNumbers)

        val winningNumber = WinningNumber(winningNumbers, bonusNumber)
        val result = WinningResult.of(lottos, winningNumber)

        println()
        resultView.printStatistics(result, purchaseAmount)
    }
}
