package lotto.controller

import lotto.Lotto
import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoGame: LottoGame
) {
    fun run() {
        ready { amount, lottos, winningNumber, bonusNumber ->
            val result = play(amount, lottos, winningNumber, bonusNumber)
            outputView.printLottoWinningResults(result)
        }
    }

    private inline fun ready(action: (purchaseAmount: Int, lottos: List<Lotto>, winningNumber: Lotto, bonusNumber: Int) -> Unit) {
        // purchase amount
        val amount = getInputAfterGuide(outputView::printAmountGuide) { inputView.inputPurchaseAmount() }
        val quantity = lottoGame.getQuantity(amount)
        outputView.printQuantity(quantity)

        // issue tickets
        val lottos = lottoGame.issueLottoTickets(quantity)
        outputView.printLottoNumbers(lottos)

        // winning numbers
        val winningNumber = getInputAfterGuide(outputView::printWinningNumberGuide) { inputView.inputWinningNumber() }
        val bonusNumber = getInputAfterGuide(outputView::printBonusNumberGuide) { inputView.inputBonusNumber(winningNumber) }

        // play
        action(amount, lottos, winningNumber, bonusNumber)
    }

    private inline fun <T> getInputAfterGuide(printMessage: () -> Unit, input: () -> T): T {
        printMessage()
        return input()
    }

}
