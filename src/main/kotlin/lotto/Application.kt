package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val purchaseAmount = inputView.getPurchaseAmount()
    val budget = Budget(purchaseAmount)

    val lotteryMachine = LotteryMachine(budget, RandomNumbersStrategy())

    outputView.printLottoTickets(lotteryMachine.generateTickets())

    val numbers = inputView.getWinningNumbers()
    val winningNumbers = Lotto(numbers)

    val bonusNumber = inputView.getBonusNumber()
    WinningLotto(winningNumbers, bonusNumber)
}
