package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(private val inputView: InputView = InputView()) {

  fun play() {
  
    // get purchase amount
    val purchaseAmount = inputView.readPurchaseAmount()
    // generate and display tickets 
  
    // get winning numbers
    val winningNumbers = inputView.readWinningNumbers()
    // get bonus
    val bonusNumber = inputView.readBonusNumber()
	  // calculate winnings
    
    // display result
  }
}