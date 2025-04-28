package lotto

import lotto.view.InputView
import lotto.view.OutputView
import camp.nextstep.edu.missionutils.Randoms
class LottoGame(private val inputView: InputView = InputView()) {

  fun play() {
  
    // get purchase amount
    val purchaseAmount = inputView.readPurchaseAmount()
    // generate and display tickets 
    val tickets = generateTickets(purchaseAmount)
    // get winning numbers
    val winningNumbers = inputView.readWinningNumbers()
    // get bonus
    val bonusNumber = inputView.readBonusNumber()
	  // calculate winnings
    
    // display result
  }

  private fun generateTickets(purchaseAmount: Long): List<Lotto> {
    val ticketCount = purchaseAmount / TICKET_PRICE
    val tickets = mutableListOf<Lotto>()
    for (i in 1..ticketCount) {
      tickets.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
    }
    return tickets
  }
}