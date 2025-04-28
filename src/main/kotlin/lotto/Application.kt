package lotto

import lotto.domain.LottoMachine
import lotto.domain.Rank
import lotto.domain.Result
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView


fun main() {
    val amount = readPurchaseAmountSafely()
    val lottoMachine = LottoMachine()
    val tickets = lottoMachine.issueTickets(amount)

    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val winningNumbersObj = WinningNumbers(winningNumbers, bonusNumber)
    val result = lotto.domain.Result()
    result.evaluate(tickets, winningNumbersObj)

    OutputView.printResult(result, amount)
}

/**
 * Reads the purchase amount from user safely, retrying on invalid input.
 */
fun readPurchaseAmountSafely(): Int {
    while (true) {
        try {
            return InputView.readPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message) // Print [ERROR] message
        }
    }
}