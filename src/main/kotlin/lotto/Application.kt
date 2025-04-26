package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val purchaseAmount = inputView.getPurchaseAmount()
    val budget = Budget(purchaseAmount)

    val lotteryMachine = LotteryMachine(budget, RandomNumbersStrategy())

    val tickets = lotteryMachine.generateTickets()
    outputView.printLottoTickets(tickets)

    val numbers = inputView.getWinningNumbers()
    val winningNumbers = Lotto(numbers)

    val bonusNumber = inputView.getBonusNumber()
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)


    val lottoRanks = winningLotto.match(tickets)

    outputView.printWinningStatistics(WinningResult(lottoRanks, budget))
}
