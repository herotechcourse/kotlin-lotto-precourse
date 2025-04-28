package lotto
import lotto.view.InputView
import lotto.view.OutputView

class Application {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoMachine = LottoMachine()

    fun run() {
        val money = readPurchaseWithRetry()
        val tickets = lottoMachine.generateTickets(money)
        outputView.printPurchasedTickets(tickets)
        val winningNumbers = readWinningNumbersWithRetry()
        val bonusNumber = readBonusNumberWithRetry(winningNumbers)
        val result = lottoMachine.calculateResult(tickets, winningNumbers, bonusNumber)
        outputView.printResult(result, money)

    }

    private fun readPurchaseWithRetry(): Int {
        while (true) {
            try {
                return inputView.readPurchaseAmount()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readWinningNumbersWithRetry(): List<Int> {
        while (true) {
            try {
                return inputView.readWinningNumbers()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readBonusNumberWithRetry(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                return inputView.readBonusNumber(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}

fun main() {
    Application().run()
}
