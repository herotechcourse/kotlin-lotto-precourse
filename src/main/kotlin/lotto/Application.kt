package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.service.LottoService
import lotto.exception.LottoInputException
import lotto.domain.WinningNumbers

fun <T> retryInputUntilSuccess(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: LottoInputException) {
            println(e.message);
        }
    }
}

fun main() {
    val amount: Int =
        retryInputUntilSuccess { InputView.getPurchaseAmount().also { LottoService.validatePurchaseAmount(it) } }
    val tickets: List<Lotto> = LottoService.generateTickets(amount)
    println()
    OutputView.printTickets(tickets)
    println()
    val winningNumbersInput: List<Int> =
        retryInputUntilSuccess { InputView.getWinningNumbers().also { LottoService.validateWinningNumbers(it) } }
    println()
    val bonusNumber: Int =
        retryInputUntilSuccess { InputView.getBonusNumber().also { LottoService.validateBonusNumber(it) } }

    val winningNumbers = WinningNumbers(winningNumbersInput, bonusNumber)
}