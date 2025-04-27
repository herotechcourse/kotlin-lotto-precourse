package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun play() {
        val budget = retry { getBudget() }
        val tickets = generateTickets(budget)
        outputView.printLottoTickets(tickets)

        val winningNumbers = retry { getWinningNumbers() }
        val winningLotto = retry { getWinningLotto(winningNumbers) }
        val result = getResult(winningLotto, tickets, budget)
        outputView.printWinningStatistics(result)
    }

    private fun getBudget(): Budget {
        val purchaseAmount = inputView.getPurchaseAmount()
        return Budget(purchaseAmount)
    }

    private fun generateTickets(budget: Budget): List<Lotto> {
        val lotteryMachine = LotteryMachine(budget, RandomNumbersStrategy())
        val tickets = lotteryMachine.generateTickets()
        return tickets
    }

    private fun getWinningNumbers(): Lotto {
        val numbers = inputView.getWinningNumbers()
        return Lotto(numbers)
    }

    private fun getWinningLotto(winningNumbers: Lotto): WinningLotto {
        val bonusNumber = inputView.getBonusNumber()
        return WinningLotto(winningNumbers, bonusNumber)
    }

    private fun getResult(
        winningLotto: WinningLotto,
        tickets: List<Lotto>,
        budget: Budget
    ): WinningResult {
        val lottoRanks = winningLotto.match(tickets)
        val result = WinningResult(lottoRanks, budget)
        return result
    }
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
