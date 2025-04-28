package lotto.controller

import lotto.Lotto
import lotto.model.LottoResult
import lotto.model.Prize
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView
import lotto.controller.CreateController

class LottoController(private val inputView: InputView, private val outputView: OutputView, private val createController: CreateController) {
  fun run() {
    try {
      val purchaseAmount = inputView.readPurchaseAmount()
      val tickets = purchaseLottoTickets(purchaseAmount)
      outputView.printPurchasedTickets(tickets)

      val winningNumbers = inputView.readWinningNumbers()
      val bonusNumber = inputView.readBonusNumber()
      val winningLotto = WinningLotto(winningNumbers, bonusNumber)

      val result = createController.matchWinningLotto(tickets, winningLotto)
      outputView.printLottoResult(result)
    } catch (e: IllegalArgumentException) {
      println(e.message)
      run()
    }
  }

  private fun purchaseLottoTickets(purchaseAmount: Int): List<Lotto> {
    return createController.createLottoTickets(purchaseAmount)
  }

  private fun getPurchaseAmount(): Int {
    return inputView.readPurchaseAmount()
  }
  private fun getWinningNumbers(): List<Int> {
    return inputView.readWinningNumbers()
  }
  private fun getBonusNumber(): Int {
    return inputView.readBonusNumber()
  }
}