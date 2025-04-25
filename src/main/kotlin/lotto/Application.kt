package lotto

import lotto.domain.*
import lotto.service.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val amount = retryUntilSuccess { inputView.inputAmount() }
    val tickets = LottoTickets.generate(amount)
    outputView.printTickets(tickets)

    val winningNumbers = retryUntilSuccess { inputView.inputWinningNumbers() }
    val bonusNumber = retryUntilSuccess { inputView.inputBonusNumber(winningNumbers) }

    val winning = WinningNumbers(winningNumbers, bonusNumber)
    val game = LottoGame(tickets, winning)
    val result = game.evaluate()

    outputView.printStatistics(result)
    outputView.printProfitRate(result, amount)
}

/**
 * Utility function that repeatedly runs the given block until it succeeds.
 * Catches [IllegalArgumentException], prints error message , and prompts again.
 */
fun <T> retryUntilSuccess(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
