package lotto

import lotto.view.InputView
import lotto.view.OutputView
import camp.nextstep.edu.missionutils.Randoms
class LottoGame(private val inputView: InputView = InputView(),
                private val outputView: OutputView = OutputView(),
                private val resultCalculator: LottoResultCalculator = LottoResultCalculator()) {

  fun play() {
  
    // get purchase amount
    val purchaseAmount = inputView.readPurchaseAmount()
    // generate and display tickets 
    val tickets = generateTickets(purchaseAmount)
    outputView.printTickets(tickets)
    // get winning numbers
    val winningNumbers = inputView.readWinningNumbers()
    // get bonus
    val bonusNumber = inputView.readBonusNumber()
	  // calculate winnings
    val result = resultCalculator.calculate(tickets, winningNumbers, bonusNumber)
    // display result
    outputView.printResults(result.winners)
    outputView.printProfitRate(result.profitRate)
  }

  private fun generateTickets(purchaseAmount: Long): List<Lotto> {
    val ticketCount = purchaseAmount / TICKET_PRICE
    val tickets = mutableListOf<Lotto>()
    for (i in 1..ticketCount) {
      tickets.add(Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE)))
    }
    return tickets
  }
}