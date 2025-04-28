package lotto

import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import lotto.service.LottoService
import lotto.service.ResultService
import lotto.service.StatisticsService
import lotto.utils.Utils
import lotto.view.InputView
import lotto.view.OutputView

/**
 * Main entry point and the orchestrator of the Lotto application.
 * The program guides the user through the purchase process, input validation,
 * ticket generation, result evaluation, and finally displays the results.
 */
fun main() {
    // Get and validate the purchase amount from the user
    val amount: Int =
        Utils.retryInputUntilSuccess { InputView.getPurchaseAmount().also { LottoService.validatePurchaseAmount(it) } }
    // Calculate the number of tickets to generate based on the purchase amount
    val ticketsQuantity = amount / LottoConstants.TICKET_PRICE
    val tickets: List<Lotto> = LottoService.generateTickets(ticketsQuantity)
    println()

    // Print the generated tickets to the user
    OutputView.printTickets(tickets)
    println()

    // Get and validate the winning numbers from the user
    val winningNumbersInput: List<Int> =
        Utils.retryInputUntilSuccess { InputView.getWinningNumbers().also { LottoService.validateWinningNumbers(it) } }
    println()


    // Get and validate the bonus number from the user
    val bonusNumber: Int =
        Utils.retryInputUntilSuccess {
            InputView.getBonusNumber().also { LottoService.validateBonusNumber(it, winningNumbersInput) }
        }
    println()

    // Create the WinningNumbers object
    val winningNumbers = WinningNumbers(winningNumbersInput, bonusNumber)
    // Evaluate the results of the tickets
    val lottoResults: List<LottoResult> = tickets.map { ResultService.evaluateTicket(it, winningNumbers) }
    // Calculate the return rate based on the results and the purchase amount
    val returnRate = StatisticsService.calculateReturnRate(lottoResults, amount)

    // Print the winning statistics and the return rate
    OutputView.printWinningStatistics(lottoResults)
    OutputView.printReturnRate(returnRate)
}