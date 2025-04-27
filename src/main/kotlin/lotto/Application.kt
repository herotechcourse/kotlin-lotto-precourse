package lotto
import lotto.view.InputView

class Application {
    private val inputView = InputView()

    fun run() {
        val money = readPurchaseWithRetry()
        val winningNumbers = readWinningNumbersWithRetry()
        val bonusNumber = readBonusNumberWithRetry(winningNumbers)

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
