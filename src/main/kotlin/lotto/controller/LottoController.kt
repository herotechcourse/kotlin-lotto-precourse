package lotto.controller

import lotto.model.Lotto

class LottoController(private val inputView: InputView) {
  fun run() {
    try {
      val purchaseAmount = inputView.readPurchaseAmount()

      val winningNumbers = inputView.readWinningNumbers()
      val bonusNumber = inputView.readBonusNumber()
    } catch (e: IllegalArgumentException) {
      println(e.message)
    }
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