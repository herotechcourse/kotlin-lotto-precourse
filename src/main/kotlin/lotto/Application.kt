package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val budget = retry {
        val purchaseAmount = inputView.getPurchaseAmount()
        Budget(purchaseAmount)
    }
    val lotteryMachine = LotteryMachine(budget, RandomNumbersStrategy())

    val tickets = lotteryMachine.generateTickets()
    outputView.printLottoTickets(tickets)

    val winningNumbers = retry {
        val numbers = inputView.getWinningNumbers()
        Lotto(numbers)
    }

    val winningLotto = retry {
        val bonusNumber = inputView.getBonusNumber()
        WinningLotto(winningNumbers, bonusNumber)
    }

    val lottoRanks = winningLotto.match(tickets)
    outputView.printWinningStatistics(WinningResult(lottoRanks, budget))
}

private inline fun <T> retry(function: () -> T): T {
    while (true) {
        try {
            return function()
        } catch (exception: IllegalArgumentException) {
            print("[ERROR] ${exception.message}")
        }
    }
}
