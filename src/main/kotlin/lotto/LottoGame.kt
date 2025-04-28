package lotto

import lotto.view.InputView
import lotto.view.OutputView
import camp.nextstep.edu.missionutils.Randoms
class LottoGame(private val inputView: InputView = InputView(),
                private val outputView: OutputView = OutputView(),
                private val resultCalculator: LottoResultCalculator = LottoResultCalculator(),
                private val validator: LottoValidator = LottoValidator()) {

  fun play() {
  
    val purchaseAmount = readPurchaseAmount()
    val tickets = generateTickets(purchaseAmount)
    outputView.printTickets(tickets)

    val winningNumbers = readWinningNumbers()
    val bonusNumber = readBonusNumber(winningNumbers)

    val result = resultCalculator.calculate(tickets, winningNumbers, bonusNumber)
    outputView.printResults(result.winners)
    outputView.printProfitRate(result.profitRate)
  }

  fun readPurchaseAmount(): Long {
    while (true) {
      try {
        return validator.validatePurchaseAmount(inputView.readPurchaseAmount())
      } catch (e: IllegalArgumentException) {
        println(e.message)
      }
    }
  }

  fun readWinningNumbers(): List<Int> {
    while (true) {
      try {
        return validator.validateWinningNumbers(inputView.readWinningNumbers())
      } catch (e: IllegalArgumentException) {
        println(e.message)
      }
    }
  }

  fun readBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
      try {
        return validator.validateBonusNumber(inputView.readBonusNumber(), winningNumbers)
      } catch (e: IllegalArgumentException) {
        println(e.message)
      }
    }
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