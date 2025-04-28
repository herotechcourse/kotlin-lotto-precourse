package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.service.LottoService
import lotto.exception.LottoInputException
import lotto.domain.WinningNumbers
import lotto.domain.LottoResult
import lotto.service.ResultService
import lotto.service.StatisticsService

fun <T> retryInputUntilSuccess(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: LottoInputException) {
            println(e.message);
            println()
        }
    }
}

fun main() {
    val amount: Int =
        retryInputUntilSuccess { InputView.getPurchaseAmount().also { LottoService.validatePurchaseAmount(it) } }
    val ticketsQuantity = amount / 1000
    val tickets: List<Lotto> = LottoService.generateTickets(ticketsQuantity)
    println()

    OutputView.printTickets(tickets)
    println()

    val winningNumbersInput: List<Int> =
        retryInputUntilSuccess { InputView.getWinningNumbers().also { LottoService.validateWinningNumbers(it) } }
    println()

    val bonusNumber: Int =
        retryInputUntilSuccess {
            InputView.getBonusNumber().also { LottoService.validateBonusNumber(it, winningNumbersInput) }
        }
    println()

    val winningNumbers = WinningNumbers(winningNumbersInput, bonusNumber)
    val lottoResults: List<LottoResult> = tickets.map { ResultService.evaluateTicket(it, winningNumbers)}
    val returnRate = StatisticsService.calculateReturnRate(lottoResults, amount)

    OutputView.printWinningStatistics(lottoResults)
    OutputView.printReturnRate(returnRate)
}